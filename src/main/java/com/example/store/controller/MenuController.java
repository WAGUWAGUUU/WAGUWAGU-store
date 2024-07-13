package com.example.store.controller;
import com.example.store.dto.request.MenuCategoryRequestDto;
import com.example.store.dto.request.MenuRequestDto;
import com.example.store.service.MenuCategoryService;
import com.example.store.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

}
