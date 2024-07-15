package com.example.store.dto.request;

import com.example.store.global.entity.MenuCategory;
import com.example.store.global.entity.Store;

public record MenuCategoryRequestDto(
        String menuCategoryName, Long storeId
) {
    public MenuCategory toEntity() {
        Store store = Store.builder().storeId(this.storeId).build();
        return MenuCategory.builder()
                .menuCategoryName(menuCategoryName)
                .store(store)
                .menuCategoryIsDeleted(false)
                .build();
    }
}
