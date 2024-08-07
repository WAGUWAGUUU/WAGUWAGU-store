package com.example.store.controller;
import com.example.store.dto.request.MenuCategoryRequestDto;
import com.example.store.dto.request.UpdateMenuCategoryRequestDto;
import com.example.store.dto.response.MenuCategoryResponse;
import com.example.store.service.MenuCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("api/v1/menu-category")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
public class MenuCategoryController {
    private final MenuCategoryService menuCategoryService;


    @MutationMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMenuCategory(@Argument(name = "input") MenuCategoryRequestDto input) {
        menuCategoryService.createMenuCategory(input);
    }

    @QueryMapping
    public MenuCategoryResponse getMenuCategoryById(@Argument(name = "menuCategoryId") Long menuCategoryId) {
        return menuCategoryService.getMenuCategoryById(menuCategoryId);
    }

    @QueryMapping
    public List<MenuCategoryResponse> getMenuCategoryByStoreId(@Argument(name = "storeId") Long storeId) {
        return menuCategoryService.getAllMenuCategoryByStoreId(storeId);
    }

    @QueryMapping
    public List<MenuCategoryResponse> getAllMenuCategory() {
        return menuCategoryService.getAllMenuCategory();
    }

    @MutationMapping
    public void updateMenuCategoryName(@Argument(name = "menuCategoryId") Long menuCategoryId, @Argument(name="input") UpdateMenuCategoryRequestDto input) {
        menuCategoryService.updateMenuCategoryName(menuCategoryId, input);
    }

    @MutationMapping
    public void deleteMenuCategory(@Argument(name = "menuCategoryId") Long menuCategoryId) {
        menuCategoryService.deleteMenuCategory(menuCategoryId);
    }
}
