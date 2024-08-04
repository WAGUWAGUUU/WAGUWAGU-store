package com.example.store.controller;
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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("api/v1/store")
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

    @QueryMapping
    public boolean checkBlockStoreIsOpened(@Argument(name = "storeId") Long storeId) {
        return storeService.checkBlockStoreIsOpened(storeId);
    }
}
