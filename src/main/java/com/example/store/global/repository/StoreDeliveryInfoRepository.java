package com.example.store.global.repository;

import com.example.store.global.entity.StoreDeliveryInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoreDeliveryInfoRepository extends JpaRepository<StoreDeliveryInfo, Long> {
    Optional<StoreDeliveryInfo> findByStore_StoreIdAndStoreDeliveryInfoState(Long storeId, int storeDeliveryInfoState);
    List<StoreDeliveryInfo> findAllByStore_StoreId(Long storeId);
}
