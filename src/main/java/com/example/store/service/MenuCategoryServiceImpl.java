package com.example.store.service;

import com.example.store.dto.request.MenuCategoryRequestDto;
import com.example.store.dto.request.UpdateMenuCategoryRequestDto;
import com.example.store.dto.response.MenuCategoryResponse;
import com.example.store.global.entity.MenuCategory;
import com.example.store.global.exception.MenuCategoryAlreadyExistsException;
import com.example.store.global.exception.MenuCategoryNotFoundException;
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
        if(byStoreAndMenuCategoryName.isPresent()) throw new MenuCategoryAlreadyExistsException();
        MenuCategory entity = menuCategoryRequestDto.toEntity();
        menuCategoryRepository.save(entity);
    }

    @Override
    @Transactional
    public MenuCategoryResponse getMenuCategoryById(Long menuCategoryId) {

        MenuCategory menuCategory = menuCategoryRepository.findByMenuCategoryIdAndMenuCategoryIsDeletedFalse(menuCategoryId).orElseThrow(MenuCategoryNotFoundException::new);

        return MenuCategoryResponse.from(menuCategory);
    }

    @Override
    @Transactional
    public List<MenuCategoryResponse> getAllMenuCategoryByStoreId(Long storeId) {
        List<MenuCategory> allByStoreStoreIdAndMenuCategoryIsDeletedFalse = menuCategoryRepository.findAllByStore_StoreIdAndMenuCategoryIsDeletedFalse(storeId);
        System.out.println("*******************************************************************************");
        return allByStoreStoreIdAndMenuCategoryIsDeletedFalse.stream().map(MenuCategoryResponse::from).toList();
    }

    @Override
    @Transactional
    public List<MenuCategoryResponse> getAllMenuCategory() {
        List<MenuCategory> allByMenuCategoryIsDeletedFalse = menuCategoryRepository.findAllByMenuCategoryIsDeletedFalse();
        return allByMenuCategoryIsDeletedFalse.stream().map(MenuCategoryResponse::from).toList();
    }

    @Override
    @Transactional
    public void updateMenuCategoryName(Long menuCategoryId, UpdateMenuCategoryRequestDto updateMenuCategoryRequestDto) {
        MenuCategory menuCategory = menuCategoryRepository.findByMenuCategoryIdAndMenuCategoryIsDeletedFalse(menuCategoryId).orElseThrow(MenuCategoryNotFoundException::new);
        menuCategory.updateMenuCategoryName(updateMenuCategoryRequestDto);
    }

    @Override
    @Transactional
    public void deleteMenuCategory(Long menuCategoryId) {
        MenuCategory menuCategory = menuCategoryRepository.findByMenuCategoryIdAndMenuCategoryIsDeletedFalse(menuCategoryId).orElseThrow(MenuCategoryNotFoundException::new);
        menuCategory.setMenuCategoryIsDeleted();
    }
}
