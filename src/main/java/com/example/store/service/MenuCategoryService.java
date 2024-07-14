package com.example.store.service;

import com.example.store.dto.request.MenuCategoryRequestDto;
import com.example.store.dto.request.StoreRequestDto;
import com.example.store.dto.request.UpdateMenuCategoryRequestDto;
import com.example.store.global.entity.MenuCategory;

import java.util.List;

public interface MenuCategoryService {
    void createMenuCategory(MenuCategoryRequestDto menuCategoryRequestDto);

    MenuCategory getMenuCategoryById(Long menuCategoryId);

    List<MenuCategory> getAllMenuCategory();

    void updateMenuCategoryName(Long menuCategoryId, UpdateMenuCategoryRequestDto updateMenuCategoryRequestDto);

    void deleteMenuCategory(Long menuCategoryId);
}
