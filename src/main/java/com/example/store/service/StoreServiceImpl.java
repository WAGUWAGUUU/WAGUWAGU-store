package com.example.store.service;
import com.example.store.dto.request.OwnerRequestDto;
import com.example.store.dto.request.StoreRequestDto;
import com.example.store.dto.request.UpdateOwnerRequestDto;
import com.example.store.dto.request.UpdateStoreRequestDto;
import com.example.store.global.entity.Owner;
import com.example.store.global.entity.Store;
import com.example.store.global.repository.StoreRepository;
import com.example.store.global.type.UpdateOwnerType;
import com.example.store.global.type.UpdateStoreType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;
    @Override
    @Transactional
    public void createStore(StoreRequestDto storeRequestDto) {
        Optional<Store> byOwner = storeRepository.findByOwner(storeRequestDto.owner());
        if(byOwner.isPresent()) throw new IllegalArgumentException();
        Store entity = storeRequestDto.toEntity();
        storeRepository.save(entity);
    }

    @Override
    @Transactional
    public Store getStoreByStoreId(Long storeId) {
        return storeRepository.findById(storeId).orElseThrow();
    }
    @Override
    @Transactional
    public List<Store> getAllStore() {
        return storeRepository.findAll();
    }

    @Override
    @Transactional
    public void updateStore(Long storeId, UpdateStoreType updateStoreType, UpdateStoreRequestDto updateStoreRequestDto) {
        Store store = storeRepository.findById(storeId).orElseThrow();
        store.update(updateStoreType,updateStoreRequestDto);
    }

    @Override
    @Transactional
    public void deleteStore(Long storeId) {
        Store store = storeRepository.findById(storeId).orElseThrow();
        store.setStoreIsDeleted();
    }
}
