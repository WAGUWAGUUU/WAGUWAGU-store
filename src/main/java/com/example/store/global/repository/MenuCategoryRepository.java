package com.example.store.global.repository;

import com.example.store.global.entity.MenuCategory;
import com.example.store.global.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {
    Optional<MenuCategory> findByStoreAndMenuCategoryName(Store store, String menuCategoryName);
}
