package com.example.store.dto.response;

import com.example.store.global.entity.MenuCategory;

public record MenuCategoryResponseDto(
        String menuCategoryName
) {
    public static MenuCategoryResponseDto from(MenuCategory menuCategory) {
        return new MenuCategoryResponseDto(menuCategory.getMenuCategoryName());
    }
}
