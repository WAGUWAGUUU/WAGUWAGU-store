package com.example.store.controller;
import com.example.store.dto.request.MenuCategoryRequestDto;
import com.example.store.dto.request.UpdateMenuCategoryRequestDto;
import com.example.store.dto.response.MenuCategoryResponse;
import com.example.store.service.MenuCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/menu-category")
@RequiredArgsConstructor
public class MenuCategoryController {
    private final MenuCategoryService menuCategoryService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMenuCategory(@RequestBody MenuCategoryRequestDto menuCategoryRequestDto) {
        menuCategoryService.createMenuCategory(menuCategoryRequestDto);
    }

    @GetMapping("/{menuCategoryId}")
    public MenuCategoryResponse getMenuCategoryById(@PathVariable(name = "menuCategoryId") Long menuCategoryId) {
        return menuCategoryService.getMenuCategoryById(menuCategoryId);
    }

    @GetMapping
    public List<MenuCategoryResponse> getAllMenuCategory() {
        return menuCategoryService.getAllMenuCategory();
    }

    @PutMapping("/{menuCategoryId}/menu-category-name")
    public void updateMenuCategoryName(@PathVariable(name = "menuCategoryId") Long menuCategoryId, @RequestBody UpdateMenuCategoryRequestDto updateMenuCategoryRequestDto) {
        menuCategoryService.updateMenuCategoryName(menuCategoryId, updateMenuCategoryRequestDto);
    }

    @DeleteMapping("/{menuCategoryId}")
    public void deleteMenuCategory(@PathVariable(name = "menuCategoryId") Long menuCategoryId) {
        menuCategoryService.deleteMenuCategory(menuCategoryId);
    }
}
