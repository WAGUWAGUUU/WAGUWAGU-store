package com.example.store.controller;

import com.example.store.dto.request.DistanceTimeRequestDto;
import com.example.store.dto.request.UserLocation;
import com.example.store.dto.response.UserLocationReponse;
import com.example.store.service.DistanceCalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/distance-cal")
@RequiredArgsConstructor
public class DistanceCalController {
    private final DistanceCalService distanceCalService;
    @PostMapping("/store/{storeId}/accept-order")
    public UserLocationReponse acceptOrder(@PathVariable(name = "storeId")Long storeId, @RequestBody UserLocation userLocation) {
        DistanceTimeRequestDto distanceTimeRequestDto = new DistanceTimeRequestDto(userLocation.minute());
        return distanceCalService.acceptOrder(storeId, userLocation, distanceTimeRequestDto);
    }
}
