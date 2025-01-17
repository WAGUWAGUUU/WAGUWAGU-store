package com.example.store.service;

import com.example.store.dto.request.MenuCategoryRequestDto;
import com.example.store.dto.request.UpdateMenuCategoryRequestDto;
import com.example.store.dto.response.MenuCategoryResponseDto;
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
        Optional<MenuCategory> byStoreAndMenuCategoryName = menuCategoryRepository.findByStore_StoreIdAndMenuCategoryNameAndMenuCategoryIsDeletedFalse(menuCategoryRequestDto.storeId(), menuCategoryRequestDto.menuCategoryName());
        if(byStoreAndMenuCategoryName.isPresent()) throw new IllegalArgumentException();
        MenuCategory entity = menuCategoryRequestDto.toEntity();
        menuCategoryRepository.save(entity);
    }

    @Override
    @Transactional
    public MenuCategoryResponseDto getMenuCategoryById(Long menuCategoryId) {
        MenuCategory menuCategory = menuCategoryRepository.findByMenuCategoryIdAndMenuCategoryIsDeletedFalse(menuCategoryId).orElseThrow();
        return MenuCategoryResponseDto.from(menuCategory);
    }

    @Override
    @Transactional
    public List<MenuCategoryResponseDto> getAllMenuCategory() {
        List<MenuCategory> allByMenuCategoryIsDeletedFalse = menuCategoryRepository.findAllByMenuCategoryIsDeletedFalse();
        return allByMenuCategoryIsDeletedFalse.stream().map(MenuCategoryResponseDto::from).toList();
    }

    @Override
    @Transactional
    public void updateMenuCategoryName(Long menuCategoryId, UpdateMenuCategoryRequestDto updateMenuCategoryRequestDto) {
        MenuCategory menuCategory = menuCategoryRepository.findByMenuCategoryIdAndMenuCategoryIsDeletedFalse(menuCategoryId).orElseThrow();
        menuCategory.updateMenuCategoryName(updateMenuCategoryRequestDto);
    }

    @Override
    @Transactional
    public void deleteMenuCategory(Long menuCategoryId) {
        MenuCategory menuCategory = menuCategoryRepository.findByMenuCategoryIdAndMenuCategoryIsDeletedFalse(menuCategoryId).orElseThrow();
        menuCategory.setMenuCategoryIsDeleted();
    }
}
