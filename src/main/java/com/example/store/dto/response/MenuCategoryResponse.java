package com.example.store.dto.response;

import com.example.store.global.entity.MenuCategory;

public record MenuCategoryResponse(
        String menuCategoryName
) {
    public static MenuCategoryResponse from(MenuCategory menuCategory) {
        return new MenuCategoryResponse(menuCategory.getMenuCategoryName());
    }
}
