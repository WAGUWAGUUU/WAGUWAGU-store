package com.example.store.controller;
import com.example.store.dto.request.MenuRequestDto;
import com.example.store.dto.request.UpdateMenuRequestDto;
import com.example.store.dto.response.MenuResponse;
import com.example.store.global.type.UpdateMenuType;
import com.example.store.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/menu")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMenu(@RequestBody MenuRequestDto menuRequestDto) {
        menuService.createMenu(menuRequestDto);
    }

    @GetMapping("/menu-category/{menuCategoryId}")
    public List<MenuResponse> getAllMenuByMenuCategory(@PathVariable(name = "menuCategoryId") Long menuCategoryId) {
        return menuService.getAllMenuByMenuCategory(menuCategoryId);
    }

    @GetMapping("/{menuId}")
    public MenuResponse getMenuById(@PathVariable(name = "menuId") Long menuId) {
        return menuService.getMenuById(menuId);
    }

    @GetMapping
    public List<MenuResponse> getAllMenu() {
        return menuService.getAllMenu();
    }

    @PutMapping("/{menuId}/menu-name")
    public void updateMenuName(@PathVariable("menuId") Long menuId, @RequestBody UpdateMenuRequestDto updateMenuRequestDto) {
        menuService.update(menuId, UpdateMenuType.MENU_NAME, updateMenuRequestDto);
    }

    @PutMapping("/{menuId}/menu-introduction")
    public void updateMenuIntroduction(@PathVariable("menuId") Long menuId, @RequestBody UpdateMenuRequestDto updateMenuRequestDto) {
        menuService.update(menuId, UpdateMenuType.MENU_INTRODUCTION, updateMenuRequestDto);
    }

    @PutMapping("/{menuId}/menu-possible")
    public void changeMenuPossible(@PathVariable("menuId") Long menuId) {
        menuService.changeMenuPossible(menuId, UpdateMenuType.MENU_POSSIBLE);
    }

    @PutMapping("/{menuId}/menu-price")
    public void updateMenuPrice(@PathVariable("menuId") Long menuId, @RequestBody UpdateMenuRequestDto updateMenuRequestDto) {
        menuService.update(menuId, UpdateMenuType.MENU_PRICE, updateMenuRequestDto);
    }

    @DeleteMapping("/{menuId}")
    public void deleteMenu(@PathVariable(name = "menuId") Long menuId) {
        menuService.deleteMenu(menuId);
    }
}
