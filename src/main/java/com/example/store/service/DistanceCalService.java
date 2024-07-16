package com.example.store.service;

import com.example.store.dto.request.DistanceTimeRequestDto;
import com.example.store.dto.request.UserLocation;
import com.example.store.dto.response.UserLocationReponse;

public interface DistanceCalService {
    UserLocationReponse acceptOrder(Long storeId, UserLocation userLocation, DistanceTimeRequestDto distanceTimeRequestDto);
}
