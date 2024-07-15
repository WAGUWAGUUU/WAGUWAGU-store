package com.example.store.global.repository;

import com.example.store.global.entity.Menu;
import com.example.store.global.entity.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    Optional<Menu> findByMenuCategory_MenuCategoryIdAndMenuNameAndMenuIsDeletedFalse(Long menuCategoryId, String menuName);

    List<Menu> findAllByMenuCategory_MenuCategoryIdAndMenuIsDeletedFalse(Long menuCategoryId);

    Optional<Menu> findByMenuIdAndMenuIsDeletedFalse(Long menuId);

    List<Menu> findAllByMenuIsDeletedFalse();

    //    @Modifying
//    @Query("update table set isDel =true where")
}
