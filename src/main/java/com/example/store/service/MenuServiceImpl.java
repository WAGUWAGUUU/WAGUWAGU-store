package com.example.store.service;
import com.example.store.dto.request.MenuRequestDto;
import com.example.store.dto.request.UpdateMenuRequestDto;
import com.example.store.dto.response.MenuCategoryResponse;
import com.example.store.dto.response.MenuResponse;
import com.example.store.dto.response.MenuResponseByStoreId;
import com.example.store.global.entity.Menu;
import com.example.store.global.entity.Store;
import com.example.store.global.exception.MenuAlreadyExistsException;
import com.example.store.global.exception.MenuNotFoundException;
import com.example.store.global.exception.StoreNotFoundException;
import com.example.store.global.repository.MenuCategoryRepository;
import com.example.store.global.repository.MenuRepository;
import com.example.store.global.repository.StoreRepository;
import com.example.store.global.type.UpdateMenuType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final StoreRepository storeRepository;
    private final MenuCategoryRepository menuCategoryRepository;
    private final MenuRepository menuRepository;
    private final MenuCategoryService menuCategoryService;
    @Override
    @Transactional
    public void createMenu(MenuRequestDto menuRequestDto) {
        Optional<Menu> byMenuCategoryAndMenuName = menuRepository.findByMenuCategory_MenuCategoryIdAndMenuNameAndMenuIsDeletedFalse(menuRequestDto.menuCategoryId(), menuRequestDto.menuName());
        if(byMenuCategoryAndMenuName.isPresent()) throw new MenuAlreadyExistsException();
        Menu entity = menuRequestDto.toEntity();
        menuRepository.save(entity);
    }

    @Override
    @Transactional
    public List<MenuResponse> getAllMenuByMenuCategory(Long menuCategoryId) {
        List<Menu> byAllByMenuCategoryMenuCategoryId = menuRepository.findAllByMenuCategory_MenuCategoryIdAndMenuIsDeletedFalse(menuCategoryId);
        return byAllByMenuCategoryMenuCategoryId.stream().map(MenuResponse::from).toList();
    }

    @Override
    @Transactional
    public MenuResponse getMenuById(Long menuId) {

        Menu menu = menuRepository.findByMenuIdAndMenuIsDeletedFalse(menuId).orElseThrow(MenuNotFoundException::new);
        return MenuResponse.from(menu);
    }

    @Override
    @Transactional
    public List<MenuResponse> getAllMenu() {
        List<Menu> all = menuRepository.findAllByMenuIsDeletedFalse();

        return all.stream().map(MenuResponse::from).toList();
    }

    @Override
    @Transactional
    public void update(Long menuId, UpdateMenuType updateMenuType, String value) {
        Menu menu = menuRepository.findByMenuIdAndMenuIsDeletedFalse(menuId).orElseThrow(MenuNotFoundException::new);
        menu.update(updateMenuType, value);
    }

    @Override
    @Transactional
    public void changeMenuPossible(Long menuId) {
        Menu menu = menuRepository.findByMenuIdAndMenuIsDeletedFalse(menuId).orElseThrow(MenuNotFoundException::new);
        menu.changeMenuPossible();
    }

    @Override
    @Transactional
    public void deleteMenu(Long menuId) {
        Menu menu = menuRepository.findByMenuIdAndMenuIsDeletedFalse(menuId).orElseThrow(MenuNotFoundException::new);
        menu.setMenuIsDeleted();
    }

    @Override
    @Transactional
    public List<MenuResponse> getAllMenuByStoreId(Long storeId) {
        List<MenuResponse> allMenuResponses  = new ArrayList<>();
        Store store = storeRepository.findByStoreIdAndStoreIsDeletedFalse(storeId).orElseThrow(StoreNotFoundException::new);
        List<MenuCategoryResponse> allMenuCategoryByStoreId = menuCategoryService.getAllMenuCategoryByStoreId(store.getStoreId());
        allMenuCategoryByStoreId.forEach(menuCategoryResponse -> {
            List<MenuResponse> allMenuByMenuCategory = getAllMenuByMenuCategory(menuCategoryResponse.menuCategoryId());
            allMenuByMenuCategory.forEach(menuResponse -> {
                allMenuResponses.add(menuResponse);
            });
        });
        return allMenuResponses;
    }

    @Override
    public String getMenuPhotoInfo(Long menuId) {
        Menu menu = menuRepository.findByMenuIdAndMenuIsDeletedFalse(menuId).orElseThrow(MenuNotFoundException::new);
        return menu.getMenuImage();
    }

}
