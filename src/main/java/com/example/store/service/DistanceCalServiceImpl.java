package com.example.store.service;

import com.example.store.dto.kafka.KafkaDistanceDto;
import com.example.store.dto.request.DistanceTimeRequestDto;
import com.example.store.dto.request.StoreNearUserRequest;
import com.example.store.dto.request.UserLocationAndMinute;
import com.example.store.dto.request.UserLocationRequest;
import com.example.store.dto.response.StoreListDeliveryResponse;
import com.example.store.dto.response.StoreListResponse;
import com.example.store.dto.response.StoreNearUserResponse;
import com.example.store.dto.response.UserLocationResponse;
import com.example.store.global.entity.DistanceProducer;
import com.example.store.global.entity.DistanceUtility;
import com.example.store.global.entity.Store;
import com.example.store.global.entity.StoreDeliveryInfo;
import com.example.store.global.exception.StoreDeliveryInfoNotFoundException;
import com.example.store.global.exception.StoreNotFoundException;
import com.example.store.global.repository.StoreDeliveryInfoRepository;
import com.example.store.global.repository.StoreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DistanceCalServiceImpl implements DistanceCalService{
    private final StoreRepository storeRepository;
    private final DistanceUtility distanceUtility;
    private final StoreDeliveryInfoRepository storeDeliveryInfoRepository;
    private final DistanceProducer producer;
    @Override
    @Transactional
    public UserLocationResponse acceptOrder(Long storeId, UserLocationAndMinute userLocation, DistanceTimeRequestDto distanceTimeRequestDto) {
        int cost= 0;
        Store store = storeRepository.findById(storeId).orElseThrow(StoreNotFoundException::new);
        double distance = distanceUtility.distance(store.getStoreAddressX(), store.getStoreAddressY(), userLocation.longitude(), userLocation.latitude());
        List<StoreDeliveryInfo> allByStoreStoreId = storeDeliveryInfoRepository.findAllByStore_StoreId(storeId);
        if(allByStoreStoreId.isEmpty()) throw new StoreDeliveryInfoNotFoundException();
        allByStoreStoreId.sort((o1, o2) -> o1.getStoreDeliveryInfoState() - o2.getStoreDeliveryInfoState());
        for(StoreDeliveryInfo info : allByStoreStoreId) {
            if(distance < info.getStoreDeliveryInfoDistanceEnd()) {
                cost = info.getStoreDeliveryInfoFee();
                break;
            }
            if(info.getStoreDeliveryInfoState()==5) {
                cost = info.getStoreDeliveryInfoFee();
            }
        }
        // 소수점 셋째자리 내림
        distance = Math.floor(distance*10)/10.0;
        LocalDateTime due = LocalDateTime.now().plusMinutes(distanceTimeRequestDto.minute());
        KafkaDistanceDto kafkaDistanceDto = new KafkaDistanceDto(1L, store.getStoreName(), store.getStoreAddressString(), cost, distance, store.getStoreAddressY(), store.getStoreAddressX(), due);
        producer.sendToRider(kafkaDistanceDto,"assign");
        return new UserLocationResponse(distance, cost, due);
    }

    @Override
    public StoreListDeliveryResponse showStoreList(Long storeId, double longitude, double latitude) {
        int cost= 0;
        Store store = storeRepository.findById(storeId).orElseThrow(StoreNotFoundException::new);
        double distance = distanceUtility.distance(store.getStoreAddressX(), store.getStoreAddressY(), longitude, latitude);
        List<StoreDeliveryInfo> allByStoreStoreId = storeDeliveryInfoRepository.findAllByStore_StoreId(storeId);
        if(allByStoreStoreId.isEmpty()) throw new StoreDeliveryInfoNotFoundException();
        allByStoreStoreId.sort((o1, o2) -> o1.getStoreDeliveryInfoState() - o2.getStoreDeliveryInfoState());
        for(StoreDeliveryInfo info : allByStoreStoreId) {
            if(distance < info.getStoreDeliveryInfoDistanceEnd()) {
                cost = info.getStoreDeliveryInfoFee();
                break;
            }
            if(info.getStoreDeliveryInfoState()==5) {
                cost = info.getStoreDeliveryInfoFee();
            }
        }
        // 소수점 셋째자리 내림
        distance = Math.floor(distance*10)/10.0;
        return new StoreListDeliveryResponse(distance, cost);
    }

    @Override
    @Transactional
    public List<StoreListResponse> userNearStore(StoreNearUserRequest storeNearUserRequest) {
        List<StoreNearUserResponse> storeAllNearUser = storeRepository.findStoreAllNearUser(storeNearUserRequest.longitude(), storeNearUserRequest.latitude(), storeNearUserRequest.category());
        if(storeAllNearUser.isEmpty()) throw new StoreNotFoundException();

        return storeAllNearUser.stream().map(storeNearUserResponse -> {
            StoreListDeliveryResponse storeListDeliveryResponse = showStoreList(storeNearUserResponse.getStoreId(), storeNearUserRequest.longitude(), storeNearUserRequest.latitude());
            return new StoreListResponse(storeNearUserResponse.getOwnerId(), storeNearUserResponse.getStoreId(), storeNearUserResponse.getStoreName(), storeNearUserResponse.getStoreAddress(),storeNearUserResponse.getStoreLongitude(), storeNearUserResponse.getStoreLatitude(), storeNearUserResponse.getStoreMinimumOrderAmount(), storeNearUserResponse.getStoreIntroduction(), storeListDeliveryResponse.distanceFromStoreToCustomer(), storeListDeliveryResponse.deliveryFee());
        }).collect(Collectors.toList());
    }

    @Override
    public StoreListResponse storeInfoDetail(Long storeId, UserLocationRequest request) {
        Store store = storeRepository.findById(storeId).orElseThrow(StoreNotFoundException::new);
        StoreListDeliveryResponse storeListDeliveryResponse = showStoreList(storeId, request.longitude(), request.latitude());
        return new StoreListResponse(store.getOwner().getOwnerId(), store.getStoreId(),store.getStoreName(),store.getStoreAddressString(), store.getStoreAddressX(), store.getStoreAddressY(), store.getStoreMinimumOrderAmount(),store.getStoreIntroduction(), storeListDeliveryResponse.distanceFromStoreToCustomer(), storeListDeliveryResponse.deliveryFee());
    }
}
