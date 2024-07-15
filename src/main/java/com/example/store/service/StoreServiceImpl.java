package com.example.store.service;
import com.example.store.dto.request.OwnerRequestDto;
import com.example.store.dto.request.StoreRequestDto;
import com.example.store.dto.request.UpdateOwnerRequestDto;
import com.example.store.dto.request.UpdateStoreRequestDto;
import com.example.store.dto.response.StoreResponseDto;
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

    // 삭제 된 거는 조회가 안 되게끔 했음
    @Override
    @Transactional
    public void createStore(StoreRequestDto storeRequestDto) {
        Optional<Store> byOwner = storeRepository.findByOwner_OwnerIdAndStoreIsDeletedFalse(storeRequestDto.ownerId());
        if(byOwner.isPresent()) throw new IllegalArgumentException();
        Store entity = storeRequestDto.toEntity();
        storeRepository.save(entity);
    }

    @Override
    @Transactional
    public StoreResponseDto getStoreByStoreId(Long storeId) {
        Store store = storeRepository.findByStoreIdAndStoreIsDeletedFalse(storeId).orElseThrow();
        return StoreResponseDto.from(store);
    }
    @Override
    @Transactional
    public List<StoreResponseDto> getAllStore() {
        List<Store> allByStoreIsDeletedFalse = storeRepository.findAllByStoreIsDeletedFalse();
        return allByStoreIsDeletedFalse.stream().map(StoreResponseDto::from).toList();
    }

    @Override
    @Transactional
    public void updateStore(Long storeId, UpdateStoreType updateStoreType, UpdateStoreRequestDto updateStoreRequestDto) {
        Store store = storeRepository.findByStoreIdAndStoreIsDeletedFalse(storeId).orElseThrow();
        store.update(updateStoreType,updateStoreRequestDto);
    }

    @Override
    @Transactional
    public void deleteStore(Long storeId) {
        Store store = storeRepository.findByStoreIdAndStoreIsDeletedFalse(storeId).orElseThrow();
        store.setStoreIsDeleted();
    }
}
