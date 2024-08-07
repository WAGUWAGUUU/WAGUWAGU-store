package com.example.store.controller;

import com.example.store.dto.request.StoreDeliveryInfoRequestDto;
import com.example.store.dto.request.UpdateStoreDeliveryInfoRequestDto;
import com.example.store.dto.response.StoreDeliveryInfoResponse;
import com.example.store.global.type.UpdateStoreDeliveryInfoType;
import com.example.store.service.StoreDeliveryInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("api/v1")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
public class StoreDeliveryInfoController {
    private final StoreDeliveryInfoService storeDeliveryInfoService;

    @MutationMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStoreDeliveryInfo(@Argument(name = "storeId")Long storeId, @Argument(name="input") StoreDeliveryInfoRequestDto input){
        storeDeliveryInfoService.createStoreDeliveryInfo(storeId, input);
    }

    @QueryMapping
    public List<StoreDeliveryInfoResponse> getStoreDeliveryInfoAllByStoreId (@Argument(name = "storeId")Long storeId){
        return storeDeliveryInfoService.getStoreDeliveryInfoAllByStoreId(storeId);
    }

//    @PutMapping("/store/{storeId}/store-delivery-info/{storeDeliveryInfoState}")
//    public void updateStoreDeliveryInfo (@PathVariable(name = "storeId")Long storeId, @PathVariable(name = "storeDeliveryInfoState")int storeDeliveryInfoState, @RequestParam(name = "type")String type, @RequestBody UpdateStoreDeliveryInfoRequestDto updateStoreDeliveryInfoRequestDto){
//        storeDeliveryInfoService.updateStoreDeliveryInfoByStoreIdAndState(storeId, storeDeliveryInfoState, UpdateStoreDeliveryInfoType.stringToStoreDeliveryInfoType(type),updateStoreDeliveryInfoRequestDto);
//    }

    @MutationMapping
    public void updateStoreDeliveryInfo(@Argument(name = "storeId") Long storeId, @Argument(name = "input") StoreDeliveryInfoRequestDto input){
        storeDeliveryInfoService.updateStoreDeliveryInfo(storeId, input);
    }
//    구간 범위는 무조건 존재해야하므로 delete 대신 put 만 쓰기
}
