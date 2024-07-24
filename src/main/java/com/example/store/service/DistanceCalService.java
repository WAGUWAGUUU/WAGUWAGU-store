package com.example.store.service;

import com.example.store.dto.request.DistanceTimeRequestDto;
import com.example.store.dto.request.StoreNearUserRequest;
import com.example.store.dto.request.UserLocationAndMinute;
import com.example.store.dto.request.UserLocationRequest;
import com.example.store.dto.response.StoreListDeliveryResponse;
import com.example.store.dto.response.StoreListResponse;
import com.example.store.dto.response.StoreNearUserResponse;
import com.example.store.dto.response.UserLocationResponse;

import java.util.List;

public interface DistanceCalService {
    UserLocationResponse acceptOrder(Long storeId, UserLocationAndMinute userLocation, DistanceTimeRequestDto distanceTimeRequestDto);

    StoreListDeliveryResponse showStoreList(Long storeId, double longitude, double latitude);


    List<StoreListResponse>  userNearStore(StoreNearUserRequest storeNearUserRequest);

    StoreListResponse storeInfoDetail(Long storeId, UserLocationRequest request);
}
