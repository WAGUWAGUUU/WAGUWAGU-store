package com.example.store.controller;
import com.example.store.dto.request.OwnerRequestDto;
import com.example.store.dto.request.StoreRequestDto;
import com.example.store.dto.request.UpdateOwnerRequestDto;
import com.example.store.dto.request.UpdateStoreRequestDto;
import com.example.store.dto.response.StoreResponseDto;
import com.example.store.global.entity.Owner;
import com.example.store.global.entity.Store;
import com.example.store.global.type.UpdateOwnerType;
import com.example.store.global.type.UpdateStoreType;
import com.example.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/store")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStore(@RequestBody StoreRequestDto storeRequestDto) {
        storeService.createStore(storeRequestDto);
    }

    @GetMapping("/{storeId}")
    @ResponseStatus(HttpStatus.OK)
    public StoreResponseDto getStoreByStoreId(@PathVariable(name = "storeId") Long storeId) {
        return storeService.getStoreByStoreId(storeId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StoreResponseDto> getAllStore() {
        return storeService.getAllStore();
    }

    @PutMapping("/{storeId}/store-name")
    @ResponseStatus(HttpStatus.OK)
    public void updateStoreName(@PathVariable(name = "storeId") Long storeId, @RequestBody UpdateStoreRequestDto updateStoreRequestDto) {
        storeService.updateStore(storeId, UpdateStoreType.STORE_NAME, updateStoreRequestDto);
    }

    @PutMapping("/{storeId}/store-address")
    @ResponseStatus(HttpStatus.OK)
    public void updateStoreAddress(@PathVariable(name = "storeId") Long storeId, @RequestBody UpdateStoreRequestDto updateStoreRequestDto) {
        storeService.updateStore(storeId, UpdateStoreType.STORE_ADDRESS_STRING, updateStoreRequestDto);
    }

    @PutMapping("/{storeId}/store-open-at")
    @ResponseStatus(HttpStatus.OK)
    public void updateStoreOpenAt(@PathVariable(name = "storeId") Long storeId, @RequestBody UpdateStoreRequestDto updateStoreRequestDto) {
        storeService.updateStore(storeId, UpdateStoreType.STORE_OPEN_AT, updateStoreRequestDto);
    }

    @PutMapping("/{storeId}/store-close-at")
    @ResponseStatus(HttpStatus.OK)
    public void updateStoreCloseAt(@PathVariable(name = "storeId") Long storeId, @RequestBody UpdateStoreRequestDto updateStoreRequestDto) {
        storeService.updateStore(storeId, UpdateStoreType.STORE_CLOSE_AT, updateStoreRequestDto);
    }

    @PutMapping("/{storeId}/store-phone")
    @ResponseStatus(HttpStatus.OK)
    public void updateStorePhone(@PathVariable(name = "storeId") Long storeId, @RequestBody UpdateStoreRequestDto updateStoreRequestDto) {
        storeService.updateStore(storeId, UpdateStoreType.STORE_PHONE, updateStoreRequestDto);
    }

    @PutMapping("/{storeId}/store-minimum-order-amount")
    @ResponseStatus(HttpStatus.OK)
    public void updateStoreMinimumOrderAmount(@PathVariable(name = "storeId") Long storeId, @RequestBody UpdateStoreRequestDto updateStoreRequestDto) {
        storeService.updateStore(storeId, UpdateStoreType.STORE_MINIMUM_ORDER_AMOUNT, updateStoreRequestDto);
    }

    @PutMapping("/{storeId}/store-introduction")
    @ResponseStatus(HttpStatus.OK)
    public void updateStoreIntroduction(@PathVariable(name = "storeId") Long storeId, @RequestBody UpdateStoreRequestDto updateStoreRequestDto) {
        storeService.updateStore(storeId, UpdateStoreType.STORE_INTRODUCTION, updateStoreRequestDto);
    }

    @PutMapping("/{storeId}/store-category")
    @ResponseStatus(HttpStatus.OK)
    public void updateStoreCategory(@PathVariable(name = "storeId") Long storeId, @RequestBody UpdateStoreRequestDto updateStoreRequestDto) {
        storeService.updateStore(storeId, UpdateStoreType.STORE_CATEGORY, updateStoreRequestDto);
    }

    @DeleteMapping("/{storeId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStore(@PathVariable(name = "storeId") Long storeId) {
        storeService.deleteStore(storeId);
    }

}
