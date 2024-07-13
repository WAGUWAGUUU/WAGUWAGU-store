package com.example.store.dto.request;

import com.example.store.global.entity.Menu;
import com.example.store.global.entity.MenuCategory;

public record MenuRequestDto(
        String menuName, String menuIntroduction, int menuPrice, MenuCategory menuCategory
) {
    public Menu toEntity() {
        return Menu.builder()
                .menuName(menuName)
                .menuIntroduction(menuIntroduction)
                .menuPrice(menuPrice)
                .menuPossible(true)
                .menuCategory(menuCategory)
                .build();
    }
}
