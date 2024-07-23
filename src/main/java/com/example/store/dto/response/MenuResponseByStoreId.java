package com.example.store.dto.response;

import com.example.store.global.entity.Menu;
import com.example.store.global.entity.MenuCategory;

public record MenuResponseByStoreId(
        Long menuId, String menuName, String menuIntroduction, int menuPrice, boolean menuPossible,
        MenuCategory menuCategory
) {

    public static MenuResponseByStoreId from(Menu menu) {
        return new MenuResponseByStoreId(menu.getMenuId(), menu.getMenuName(), menu.getMenuIntroduction(), menu.getMenuPrice(), menu.isMenuPossible(), menu.getMenuCategory());
    }
}
