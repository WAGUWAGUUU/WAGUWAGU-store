package com.example.store.service;

import com.example.store.dto.request.MenuCategoryRequestDto;
import com.example.store.dto.request.StoreRequestDto;

public interface MenuCategoryService {
    void createMenuCategory(MenuCategoryRequestDto menuCategoryRequestDto);
}
