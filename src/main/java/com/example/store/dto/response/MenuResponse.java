package com.example.store.dto.response;

import com.example.store.global.entity.Menu;

public record MenuResponse(
      String menuName, String menuIntroduction, int menuPrice, boolean menuPossible
) {

    public static MenuResponse from(Menu menu) {
        return new MenuResponse(menu.getMenuName(), menu.getMenuIntroduction(), menu.getMenuPrice(), menu.isMenuPossible());
    }
}
