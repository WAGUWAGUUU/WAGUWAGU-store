package com.example.store.controller;
import com.example.store.dto.request.MenuCategoryRequestDto;
import com.example.store.dto.request.OwnerRequestDto;
import com.example.store.service.MenuCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
