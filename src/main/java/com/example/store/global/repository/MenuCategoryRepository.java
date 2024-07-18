package com.example.store.global.repository;

import com.example.store.global.entity.MenuCategory;
import com.example.store.global.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {
    Optional<MenuCategory> findByStore_StoreIdAndMenuCategoryNameAndMenuCategoryIsDeletedFalse(Long storeId, String menuCategoryName);

    Optional<MenuCategory> findByMenuCategoryIdAndMenuCategoryIsDeletedFalse(Long menuCategoryId);

    List<MenuCategory> findAllByMenuCategoryIsDeletedFalse();

    List<MenuCategory> findAllByStore_StoreIdAndMenuCategoryIsDeletedFalse(Long storeId);
}
