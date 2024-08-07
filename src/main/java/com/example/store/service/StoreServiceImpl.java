package com.example.store.service;
import com.example.store.dto.request.PhotoRequest;
import com.example.store.dto.request.StoreRequestDto;
import com.example.store.dto.request.StoreUpdateRequest;
import com.example.store.dto.request.UpdateStoreRequestDto;
import com.example.store.dto.response.StoreResponse;
import com.example.store.global.entity.Store;
import com.example.store.global.exception.StoreAlreadyExistsException;
import com.example.store.global.exception.StoreNotFoundException;
import com.example.store.global.repository.StoreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;


    // 삭제 된 거는 조회가 안 되게끔 했음
    @Override
    @Transactional
    public void createStore(StoreRequestDto storeRequestDto) {
        Optional<Store> byOwner = storeRepository.findByOwner_OwnerIdAndStoreIsDeletedFalse(storeRequestDto.ownerId());
        if(byOwner.isPresent()) throw new StoreAlreadyExistsException();
        Store entity = storeRequestDto.toEntity();
        storeRepository.save(entity);
    }

    @Override
    @Transactional
    public StoreResponse getStoreByStoreId(Long storeId) {
        Store store = storeRepository.findByStoreIdAndStoreIsDeletedFalse(storeId).orElseThrow(StoreNotFoundException::new);
        return StoreResponse.from(store);
    }

    @Override
    @Transactional
    public List<StoreResponse> getAllStore() {
        List<Store> allByStoreIsDeletedFalse = storeRepository.findAllByStoreIsDeletedFalse();
        return allByStoreIsDeletedFalse.stream().map(StoreResponse::from).toList();
    }

//    @Override
//    @Transactional
//    public void updateStore(Long storeId, UpdateStoreType updateStoreType, UpdateStoreRequestDto updateStoreRequestDto) {
//        Store store = storeRepository.findByStoreIdAndStoreIsDeletedFalse(storeId).orElseThrow(StoreNotFoundException::new);
//        store.update(updateStoreType,updateStoreRequestDto);
//    }

    @Override
    @Transactional
    public void updateStoreInfo(Long storeId, StoreUpdateRequest req) {
        Store store = storeRepository.findByStoreIdAndStoreIsDeletedFalse(storeId).orElseThrow(StoreNotFoundException::new);
        store.updateStoreInfo(req);
    }

    @Override
    @Transactional
    public void deleteStore(Long storeId) {
        Store store = storeRepository.findByStoreIdAndStoreIsDeletedFalse(storeId).orElseThrow(StoreNotFoundException::new);
        store.setStoreIsDeleted();
    }

    @Override
    public StoreResponse getStoreByOwnerId(Long ownerId) {
        Store store = storeRepository.findByOwner_OwnerIdAndStoreIsDeletedFalse(ownerId).orElseThrow(StoreNotFoundException::new);
        return StoreResponse.from(store);

    }

    @Override
    @Transactional
    public void blockStoreIsOpened(Long storeId) {
        Store store = storeRepository.findByStoreIdAndStoreIsDeletedFalse(storeId).orElseThrow(StoreNotFoundException::new);
        store.setStoreBlockIsOpened();
    }

    @Override
    public boolean checkBlockStoreIsOpened(Long storeId) {
        Store store = storeRepository.findByStoreIdAndStoreIsDeletedFalse(storeId).orElseThrow(StoreNotFoundException::new);
        return store.getStoreBlockIsOpened();
    }

    @Override
    public boolean checkStoreIsOpened(Long storeId) {
        Store store = storeRepository.findByStoreIdAndStoreIsDeletedFalse(storeId).orElseThrow(StoreNotFoundException::new);
        LocalTime now = LocalTime.now();
        return store.getStoreOpenAt().isAfter(now) && store.getStoreCloseAt().isBefore(now)  && !store.getStoreBlockIsOpened();
    }

//    @Override
//    @Transactional
//    public void updateStorePhotoInfo(Long storeId, MultipartFile input) throws IOException {
//        Store store = storeRepository.findByStoreIdAndStoreIsDeletedFalse(storeId).orElseThrow(StoreNotFoundException::new);
//        String originalName = input.getOriginalFilename();
//        String uuid = UUID.randomUUID().toString();
//        String ext = input.getContentType();
//        String fileName = uuid;
//
//        BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, fileName)
//                .setContentType(ext)
//                .build();
//
//        try {
//            storage.create(blobInfo, input.getInputStream());
//            store.updateImageInfo(fileName);
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to upload file", e);
//        }
//    }

    @Override
    public String getStorePhotoInfo(Long storeId) {
        Store store = storeRepository.findByStoreIdAndStoreIsDeletedFalse(storeId).orElseThrow(StoreNotFoundException::new);
        return store.getStoreImage();
    }
}
