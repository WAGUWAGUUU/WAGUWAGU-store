package com.example.store.service;

import com.example.store.dto.request.MenuRequestDto;
import com.example.store.dto.request.UpdateMenuRequestDto;
import com.example.store.dto.response.MenuResponse;
import com.example.store.global.type.UpdateMenuType;

import java.util.List;

public interface MenuService {
    void createMenu(MenuRequestDto menuRequestDto);
    List<MenuResponse> getAllMenuByMenuCategory(Long menuCategoryId);

    MenuResponse getMenuById(Long menuId);

    List<MenuResponse> getAllMenu();

    void update(Long menuId, UpdateMenuType updateMenuType, UpdateMenuRequestDto updateMenuRequestDto);

    void changeMenuPossible(Long menuId);

    void deleteMenu(Long menuId);


}
