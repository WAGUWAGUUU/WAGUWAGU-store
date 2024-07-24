package com.example.store.service;

import com.example.store.dto.request.MenuCategoryRequestDto;
import com.example.store.dto.request.UpdateMenuCategoryRequestDto;
import com.example.store.dto.response.MenuCategoryResponse;

import java.util.List;

public interface MenuCategoryService {
    void createMenuCategory(MenuCategoryRequestDto menuCategoryRequestDto);

    MenuCategoryResponse getMenuCategoryById(Long menuCategoryId);

    List<MenuCategoryResponse> getAllMenuCategoryByStoreId(Long storeId);

    List<MenuCategoryResponse> getAllMenuCategory();

    void updateMenuCategoryName(Long menuCategoryId, UpdateMenuCategoryRequestDto updateMenuCategoryRequestDto);

    void deleteMenuCategory(Long menuCategoryId);
}
