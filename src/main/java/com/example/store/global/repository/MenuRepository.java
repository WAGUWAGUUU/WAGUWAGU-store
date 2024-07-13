package com.example.store.global.repository;

import com.example.store.global.entity.Menu;
import com.example.store.global.entity.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    Optional<Menu> findByMenuCategoryAndMenuName(MenuCategory menuCategory, String menuName);

//    @Modifying
//    @Query("update table set isDel =true where")
}
