package com.example.store.service;

import com.example.store.dto.request.MenuCategoryRequestDto;
import com.example.store.dto.request.UpdateMenuCategoryRequestDto;
import com.example.store.global.entity.MenuCategory;
import com.example.store.global.repository.MenuCategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuCategoryServiceImpl implements MenuCategoryService{
    private final MenuCategoryRepository menuCategoryRepository;
    @Override
    @Transactional
    public void createMenuCategory(MenuCategoryRequestDto menuCategoryRequestDto) {
        Optional<MenuCategory> byStoreAndMenuCategoryName = menuCategoryRepository.findByStoreAndMenuCategoryName(menuCategoryRequestDto.store(), menuCategoryRequestDto.menuCategoryName());
        if(byStoreAndMenuCategoryName.isPresent()) throw new IllegalArgumentException();
        MenuCategory entity = menuCategoryRequestDto.toEntity();
        menuCategoryRepository.save(entity);
    }

    @Override
    @Transactional
    public MenuCategory getMenuCategoryById(Long menuCategoryId) {
        return menuCategoryRepository.findById(menuCategoryId).orElseThrow();
    }

    @Override
    @Transactional
    public List<MenuCategory> getAllMenuCategory() {
        return menuCategoryRepository.findAll();
    }

    @Override
    @Transactional
    public void updateMenuCategoryName(Long menuCategoryId, UpdateMenuCategoryRequestDto updateMenuCategoryRequestDto) {
        MenuCategory menuCategory = menuCategoryRepository.findById(menuCategoryId).orElseThrow();
        menuCategory.updateMenuCategoryName(updateMenuCategoryRequestDto);
    }

    @Override
    @Transactional
    public void deleteMenuCategory(Long menuCategoryId) {
        MenuCategory menuCategory = menuCategoryRepository.findById(menuCategoryId).orElseThrow();
        menuCategory.setMenuCategoryIsDeleted();
    }
}
