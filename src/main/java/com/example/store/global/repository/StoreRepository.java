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

    @Transactional
    @Modifying
    @Query(value = "SELECT ownerId,storeId,storeName,storeAddress,storeLongitude,storeLatitude,storeMinimumOrderAmount,storeIntroduction " +
            "FROM (" +
            "  SELECT S.owner_id AS ownerId, S.store_id AS storeId, S.store_name AS storeName,  S.store_address_string AS storeAddress, S.store_address_y AS storeLatitude, S.store_address_x AS storeLongitude, S.store_minimum_order_amount AS storeMinimumOrderAmount, S.store_introduction AS storeIntroduction, " +
            "  ST_Distance_Sphere(Point(:userX, :userY), Point(S.store_address_x, S.store_address_y)) AS distance " +
            "  FROM Stores S" +
            "  WHERE S.store_is_deleted = 0 AND S.store_category = :category"+
            ") AS temp " +
            "WHERE distance <= 5000 " +
            "ORDER BY distance",
            nativeQuery = true)
    List<StoreNearUserResponse> findStoreAllNearUser(@Param("userX") double userX, @Param("userY") double userY, @Param("category") String category);


}