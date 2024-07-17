package com.example.store.service;
import com.example.store.dto.request.StoreDeliveryInfoRequestDto;
import com.example.store.dto.request.UpdateStoreDeliveryInfoRequestDto;
import com.example.store.dto.response.StoreDeliveryInfoResponse;
import com.example.store.global.entity.Store;
import com.example.store.global.entity.StoreDeliveryInfo;
import com.example.store.global.exception.StoreDeliveryInfoAlreadyExistsException;
import com.example.store.global.exception.StoreDeliveryInfoNotFoundException;
import com.example.store.global.exception.StoreNotFoundException;
import com.example.store.global.repository.StoreDeliveryInfoRepository;
import com.example.store.global.repository.StoreRepository;
import com.example.store.global.type.UpdateStoreDeliveryInfoType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreDeliveryInfoServiceImpl implements StoreDeliveryInfoService {
    private final StoreDeliveryInfoRepository storeDeliveryInfoRepository;
    private final StoreRepository storeRepository;
    @Override
    @Transactional
    public void createStoreDeliveryInfo(Long storeId, StoreDeliveryInfoRequestDto storeDeliveryInfoRequestDto) {
        Optional<StoreDeliveryInfo> byStoreStoreIdAndStoreDeliveryInfoState = storeDeliveryInfoRepository.findByStore_StoreIdAndStoreDeliveryInfoState(storeId, storeDeliveryInfoRequestDto.storeDeliveryInfoState());
        if(byStoreStoreIdAndStoreDeliveryInfoState.isPresent()) throw new StoreDeliveryInfoAlreadyExistsException();
        Optional<Store> byId = storeRepository.findById(storeId);
        if(byId.isEmpty()) throw new StoreNotFoundException();
        StoreDeliveryInfo entity = storeDeliveryInfoRequestDto.toEntity(byId.get());
        storeDeliveryInfoRepository.save(entity);
    }

    @Override
    @Transactional
    public List<StoreDeliveryInfoResponse> getStoreDeliveryInfoAllByStoreId(Long storeId) {
        List<StoreDeliveryInfo> allByStoreStoreId = storeDeliveryInfoRepository.findAllByStore_StoreId(storeId);
        return allByStoreStoreId.stream().map(StoreDeliveryInfoResponse::from).toList();
    }

    @Override
    @Transactional
    public void updateStoreDeliveryInfoByStoreIdAndState(Long storeId, int storeDeliveryInfoState, UpdateStoreDeliveryInfoType updateStoreDeliveryInfoType, UpdateStoreDeliveryInfoRequestDto updateStoreDeliveryInfoRequestDto) {
        StoreDeliveryInfo storeDeliveryInfo = storeDeliveryInfoRepository.findByStore_StoreIdAndStoreDeliveryInfoState(storeId, storeDeliveryInfoState).orElseThrow(StoreDeliveryInfoNotFoundException::new);
        storeDeliveryInfo.update(updateStoreDeliveryInfoType, updateStoreDeliveryInfoRequestDto);
    }
}
