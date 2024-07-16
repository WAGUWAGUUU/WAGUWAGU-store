package com.example.store.service;

import com.example.store.dto.request.DistanceTimeRequestDto;
import com.example.store.dto.request.StoreNearUserRequest;
import com.example.store.dto.request.UserLocation;
import com.example.store.dto.response.StoreNearUserResponse;
import com.example.store.dto.response.StoreResponseDto;
import com.example.store.dto.response.UserLocationReponse;

import java.util.List;

public interface DistanceCalService {
    UserLocationReponse acceptOrder(Long storeId, UserLocation userLocation, DistanceTimeRequestDto distanceTimeRequestDto);

    List<StoreNearUserResponse> userNearStore(StoreNearUserRequest storeNearUserRequest);
}
