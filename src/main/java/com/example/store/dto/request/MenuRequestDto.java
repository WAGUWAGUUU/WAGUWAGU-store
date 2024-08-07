package com.example.store.dto.request;

import com.example.store.global.entity.Menu;
import com.example.store.global.entity.MenuCategory;

public record MenuRequestDto(
        String menuName, String menuIntroduction, int menuPrice, Long menuCategoryId, String menuImage
) {
    public Menu toEntity() {
        MenuCategory menuCategory = MenuCategory.builder().menuCategoryId(this.menuCategoryId).build();
        return Menu.builder()
                .menuName(menuName)
                .menuIntroduction(menuIntroduction)
                .menuPrice(menuPrice)
                .menuPossible(true)
                .menuCategory(menuCategory)
                .menuImage(menuImage)
                .build();
    }
}
