package com.example.store.global.repository;

import com.example.store.global.entity.Owner;
import com.example.store.global.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findByOwner(Owner owner);
}
