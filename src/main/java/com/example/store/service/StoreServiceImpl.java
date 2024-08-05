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
import com.example.store.global.type.UpdateStoreType;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

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

    @Value("${spring.cloud.gcp.storage.bucket}") // application.yml에 써둔 bucket 이름
    private String bucketName;

    @Value("${spring.cloud.gcp.storage.credentials.location.classpath}")
    private String keyFileName;

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

    @Override
    public void updateStorePhotoInfo(Long storeId, PhotoRequest input) throws IOException {
        Store store = storeRepository.findByStoreIdAndStoreIsDeletedFalse(storeId).orElseThrow(StoreNotFoundException::new);
        String uuid = UUID.randomUUID().toString();
        String ext = input.getImage().getContentType();
        InputStream keyFile = ResourceUtils.getURL(keyFileName).openStream();

        Storage storage = StorageOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(keyFile))
                .build()
                .getService();


        BlobId blobId = BlobId.of(bucketName, uuid);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                .setContentType(ext)
                .build();
        try (WriteChannel writer = storage.writer(blobInfo)) {
            byte[] imageData = input.getImage().getBytes(); // 이미지 데이터를 byte 배열로 읽어옵니다.
            writer.write(ByteBuffer.wrap(imageData));
        } catch (Exception ex) {
            // 예외 처리 코드
            ex.printStackTrace();
        }
        store.updateImageInfo(input, uuid);
    }
}
