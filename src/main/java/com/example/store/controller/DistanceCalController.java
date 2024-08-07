package com.example.store.controller;

import com.example.store.dto.request.DistanceTimeRequestDto;
import com.example.store.dto.request.StoreNearUserRequest;
import com.example.store.dto.request.UserLocationAndMinute;
import com.example.store.dto.request.UserLocationRequest;
import com.example.store.dto.response.StoreListResponse;
import com.example.store.dto.response.StoreNearUserResponse;
import com.example.store.dto.response.UserLocationResponse;
import com.example.store.service.DistanceCalService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("api/v1/distance-cal")
@RequiredArgsConstructor
public class DistanceCalController {
    private final DistanceCalService distanceCalService;
//    @PostMapping("/store/{storeId}/accept-order")
//    public UserLocationResponse acceptOrder(@PathVariable(name = "storeId")Long storeId, @RequestBody UserLocationAndMinute userLocation) {
//        DistanceTimeRequestDto distanceTimeRequestDto = new DistanceTimeRequestDto(userLocation.minute());
//        return distanceCalService.acceptOrder(storeId, userLocation, distanceTimeRequestDto);
//    }

    @MutationMapping
    public StoreListResponse storeInfoDetail(@Argument(name = "storeId")Long storeId, @Argument(name = "input") UserLocationRequest input) {
        return distanceCalService.storeInfoDetail(storeId, input);
    }

    @MutationMapping
    public List<StoreListResponse> userNearStore(@Argument(name = "category")String category, @Argument(name = "input") UserLocationRequest input) {
        return distanceCalService.userNearStore(category, input);
    }


}
