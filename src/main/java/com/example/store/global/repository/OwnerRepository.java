package com.example.store.global.repository;

import com.example.store.global.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
//    Optional<Owner> findByOwnerId(Long ownerId);

    Optional<Owner> findByOwnerBusinessNumber(String ownerBusinessNumber);

//    List<Owner> findAllByOwnerIsDeletedFalse();
}
