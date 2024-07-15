package com.example.store.service;

import com.example.store.dto.request.MenuRequestDto;
import com.example.store.dto.request.UpdateMenuRequestDto;
import com.example.store.dto.response.MenuResponseDto;
import com.example.store.global.entity.MenuCategory;
import com.example.store.global.type.UpdateMenuType;

import java.util.List;

public interface MenuService {
    void createMenu(MenuRequestDto menuRequestDto);
    List<MenuResponseDto> getAllMenuByMenuCategory(Long menuCategoryId);

    MenuResponseDto getMenuById(Long menuId);

    List<MenuResponseDto> getAllMenu();

    void update(Long menuId, UpdateMenuType updateMenuType, UpdateMenuRequestDto updateMenuRequestDto);

    void changeMenuPossible(Long menuId, UpdateMenuType updateMenuType);

    void deleteMenu(Long menuId);

}
