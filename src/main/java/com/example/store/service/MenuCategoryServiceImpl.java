package com.example.store.service;

import com.example.store.dto.request.MenuCategoryRequestDto;
import com.example.store.global.entity.MenuCategory;
import com.example.store.global.repository.MenuCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuCategoryServiceImpl implements MenuCategoryService{
    private final MenuCategoryRepository menuCategoryRepository;
    @Override
    public void createMenuCategory(MenuCategoryRequestDto menuCategoryRequestDto) {
        Optional<MenuCategory> byStoreAndMenuCategoryName = menuCategoryRepository.findByStoreAndMenuCategoryName(menuCategoryRequestDto.store(), menuCategoryRequestDto.menuCategoryName());
        if(byStoreAndMenuCategoryName.isPresent()) throw new IllegalArgumentException();
        MenuCategory entity = menuCategoryRequestDto.toEntity();
        menuCategoryRepository.save(entity);
    }
}
