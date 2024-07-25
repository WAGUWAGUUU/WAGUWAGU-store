package com.example.store.controller;
import com.example.store.dto.request.StoreRequestDto;
import com.example.store.dto.request.UpdateStoreRequestDto;
import com.example.store.dto.response.StoreResponse;
import com.example.store.global.entity.Store;
import com.example.store.global.type.UpdateStoreType;
import com.example.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/store")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StoreController {
    private final StoreService storeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStore(@RequestBody StoreRequestDto storeRequestDto) {
        storeService.createStore(storeRequestDto);
    }

    @GetMapping("/{storeId}")
    public StoreResponse getStoreByStoreId(@PathVariable(name = "storeId") Long storeId) {
        return storeService.getStoreByStoreId(storeId);
    }

    @GetMapping
    public List<StoreResponse> getAllStore() {
        return storeService.getAllStore();
    }

    @PutMapping("/{storeId}")
    public void updateStoreName(@PathVariable(name = "storeId") Long storeId, @RequestParam(name = "type")String type, @RequestBody UpdateStoreRequestDto updateStoreRequestDto) {
        storeService.updateStore(storeId, UpdateStoreType.stringToStoreType(type), updateStoreRequestDto);
    }

    @DeleteMapping("/{storeId}")
    public void deleteStore(@PathVariable(name = "storeId") Long storeId) {
        storeService.deleteStore(storeId);
    }

    @GetMapping("/owner/{ownerId}")
    public StoreResponse getStoreByOwnerId(@PathVariable Long ownerId) {
        return storeService.getStoreByOwnerId(ownerId);
    }
}
