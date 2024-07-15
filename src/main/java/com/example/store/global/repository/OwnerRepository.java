package com.example.store.global.repository;

import com.example.store.global.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
//    Optional<Owner> findByOwnerId(Long ownerId);

    Optional<Owner> findByOwnerBusinessNumberAndOwnerIsDeletedFalse(String ownerBusinessNumber);

    Optional<Owner> findByOwnerIsDeletedFalseAndOwnerId(Long ownerId);

    List<Owner> findAllByOwnerIsDeletedFalse();

    //    List<Owner> findAllByOwnerIsDeletedFalse();
}
