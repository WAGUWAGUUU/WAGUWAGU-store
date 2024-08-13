package com.example.store.controller;
import com.example.store.dto.request.PhotoRequest;
import com.example.store.dto.request.StoreRequestDto;
import com.example.store.dto.request.StoreUpdateRequest;
import com.example.store.dto.request.UpdateStoreRequestDto;
import com.example.store.dto.response.StoreResponse;
import com.example.store.global.entity.Store;
import com.example.store.global.type.UpdateStoreType;
import com.example.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/store")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
public class StoreController {
    private final StoreService storeService;

    @MutationMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStore(@Argument(name ="input") StoreRequestDto input) {
        storeService.createStore(input);
    }

    @QueryMapping
    public StoreResponse getStoreByStoreId(@Argument(name = "storeId") Long storeId) {
        return storeService.getStoreByStoreId(storeId);
    }

    @QueryMapping
    public List<StoreResponse> getAllStore() {
        return storeService.getAllStore();
    }

//    @PutMapping("/{storeId}")
//    public void updateStoreName(@PathVariable(name = "storeId") Long storeId, @RequestParam(name = "type")String type, @RequestBody UpdateStoreRequestDto updateStoreRequestDto) {
//        storeService.updateStore(storeId, UpdateStoreType.stringToStoreType(type), updateStoreRequestDto);
//    }

    @MutationMapping
    public void updateStoreInfo(@Argument(name = "storeId") Long storeId, @Argument(name = "input") StoreUpdateRequest input) {
        storeService.updateStoreInfo(storeId, input);
    }

    @MutationMapping
    public void deleteStore(@Argument(name = "storeId") Long storeId) {
        storeService.deleteStore(storeId);
    }

    @QueryMapping
    public StoreResponse getStoreByOwnerId(@Argument(name = "ownerId") Long ownerId) {
        return storeService.getStoreByOwnerId(ownerId);
    }

    @MutationMapping
    public void blockStoreIsOpened(@Argument(name = "storeId") Long storeId) {
        storeService.blockStoreIsOpened(storeId);
    }

    // 수동적으로 가게 영업을 막았는지만 체크
    @QueryMapping
    public boolean checkBlockStoreIsOpened(@Argument(name = "storeId") Long storeId) {
        return storeService.checkBlockStoreIsOpened(storeId);
    }

    // 가게가 영업중인지 체크(가게 영업을 막은 경우도 포함)
    @QueryMapping
    public boolean checkStoreIsOpened(@Argument(name = "storeId") Long storeId) {
        return storeService.checkStoreIsOpened(storeId);
    }


//    @QueryMapping
//    public String getStorePhotoInfo(@Argument(name = "storeId") Long storeId) {
//        return storeService.getStorePhotoInfo(storeId);
//    }

    @GetMapping("/{storeId}/photo")
    public String getStorePhotoInfo(@PathVariable(name = "storeId") Long storeId) {
        return storeService.getStorePhotoInfo(storeId);
    }


}
