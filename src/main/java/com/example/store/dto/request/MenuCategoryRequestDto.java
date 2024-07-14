package com.example.store.dto.request;

import com.example.store.global.entity.MenuCategory;
import com.example.store.global.entity.Store;

public record MenuCategoryRequestDto(
        String menuCategoryName, Store store
) {
    public MenuCategory toEntity() {
        return MenuCategory.builder()
                .menuCategoryName(menuCategoryName)
                .store(store)
                .menuCategoryIsDeleted(false)
                .build();
    }
}
