package com.example.store.controller;
import com.example.store.dto.request.MenuRequestDto;
import com.example.store.dto.request.UpdateMenuRequestDto;
import com.example.store.dto.response.MenuResponse;
import com.example.store.global.type.UpdateMenuType;
import com.example.store.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/menu")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
public class MenuController {
    private final MenuService menuService;
    @MutationMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMenu(@Argument(name = "input") MenuRequestDto input) {
        menuService.createMenu(input);
    }

    @QueryMapping
    public List<MenuResponse> getAllMenuByMenuCategory(@Argument(name = "menuCategoryId") Long menuCategoryId) {
        return menuService.getAllMenuByMenuCategory(menuCategoryId);
    }

    @QueryMapping
    public MenuResponse getMenuById(@Argument(name = "menuId") Long menuId) {
        return menuService.getMenuById(menuId);
    }


    @QueryMapping
    public List<MenuResponse> getAllMenu() {
        return menuService.getAllMenu();
    }

    @MutationMapping
    public void updateMenu(@Argument("menuId") Long menuId, @Argument(name = "input") UpdateMenuRequestDto input) {
        menuService.update(menuId, UpdateMenuType.stringToMenuType(input.type()), input.value());
    }

    @QueryMapping
    public void changeMenuPossible(@Argument("menuId") Long menuId) {
        menuService.changeMenuPossible(menuId);
    }

    @MutationMapping
    public void deleteMenu(@Argument(name = "menuId") Long menuId) {
        menuService.deleteMenu(menuId);
    }

    @QueryMapping
    public List<MenuResponse> getAllMenuByStoreId(@Argument("storeId") Long storeId) {
        return menuService.getAllMenuByStoreId(storeId);
    }

//    @GetMapping("/{menuId}/photo")
//    public String getMenuPhotoInfo(@PathVariable(name = "menuId") Long menuId) {
//        return menuService.getMenuPhotoInfo(menuId);
//    }


}
