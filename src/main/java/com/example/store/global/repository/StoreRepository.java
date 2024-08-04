package com.example.store.global.repository;

import com.example.store.dto.response.StoreNearUserResponse;
import com.example.store.global.entity.Store;
import com.example.store.global.type.StoreCategory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findByOwner_OwnerIdAndStoreIsDeletedFalse(Long ownerId);


    Optional<Store> findByStoreIdAndStoreIsDeletedFalse(Long storeId);

    List<Store> findAllByStoreIsDeletedFalse();

    Optional<Store> findByOwner_OwnerId(Long ownerId);

    @Transactional
    @Modifying
    @Query(value = "SELECT ownerId,storeId,storeName,storeAddress,storeLongitude,storeLatitude,storeMinimumOrderAmount,storeIntroduction, storeBlockIsOpened" +
            " FROM (" +
            "  SELECT S.owner_id AS ownerId, S.store_id AS storeId, S.store_name AS storeName,  S.store_address AS storeAddress, S.store_latitude AS storeLatitude, S.store_longitude AS storeLongitude, S.store_minimum_order_amount AS storeMinimumOrderAmount, S.store_introduction AS storeIntroduction, S.store_block_is_opened AS storeBlockIsOpened, S.store_open_at AS storeOpenAt, S.store_close_at AS storeCloseAt," +
            "  ST_Distance_Sphere(Point(:userLongitude, :userLatitude), Point(S.store_longitude, S.store_latitude)) AS distance " +
            "  FROM stores S" +
            "  WHERE S.store_is_deleted = 0 AND S.store_category = :category"+
            ") AS temp " +
            "WHERE distance <= 5000 AND storeBlockIsOpened = 0 And NOW() >= storeOpenAt And NOW()<= storeCloseAt" +
            " ORDER BY distance",
            nativeQuery = true)
    List<StoreNearUserResponse> findStoreAllNearUser(@Param("userLongitude") double userLongitude, @Param("userLatitude") double userLatitude, @Param("category") String category);


}