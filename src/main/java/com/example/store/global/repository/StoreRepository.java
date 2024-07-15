package com.example.store.global.repository;

import com.example.store.global.entity.Owner;
import com.example.store.global.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findByOwner_OwnerIdAndStoreIsDeletedFalse(Long ownerId);


    Optional<Store> findByStoreIdAndStoreIsDeletedFalse(Long storeId);

    List<Store> findAllByStoreIsDeletedFalse();
}
