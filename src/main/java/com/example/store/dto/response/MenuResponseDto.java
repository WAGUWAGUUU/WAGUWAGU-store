package com.example.store.dto.response;

import com.example.store.global.entity.Menu;

public record MenuResponseDto(
      String menuName, String menuIntroduction, int menuPrice, boolean menuPossible
) {

    public static MenuResponseDto from(Menu menu) {
        return new MenuResponseDto(menu.getMenuName(), menu.getMenuIntroduction(), menu.getMenuPrice(), menu.isMenuPossible());
    }
}
