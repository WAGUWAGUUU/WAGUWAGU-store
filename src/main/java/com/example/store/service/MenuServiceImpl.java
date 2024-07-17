package com.example.store.service;
import com.example.store.dto.request.MenuRequestDto;
import com.example.store.dto.request.UpdateMenuRequestDto;
import com.example.store.dto.response.MenuResponse;
import com.example.store.global.entity.Menu;
import com.example.store.global.exception.MenuAlreadyExistsException;
import com.example.store.global.exception.MenuNotFoundException;
import com.example.store.global.repository.MenuRepository;
import com.example.store.global.type.UpdateMenuType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;
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
        if(all.isEmpty()) throw new MenuNotFoundException();
        return all.stream().map(MenuResponse::from).toList();
    }

    @Override
    @Transactional
    public void update(Long menuId, UpdateMenuType updateMenuType, UpdateMenuRequestDto updateMenuRequestDto) {
        Menu menu = menuRepository.findByMenuIdAndMenuIsDeletedFalse(menuId).orElseThrow(MenuNotFoundException::new);
        menu.update(updateMenuType, updateMenuRequestDto);
    }

    @Override
    @Transactional
    public void changeMenuPossible(Long menuId, UpdateMenuType updateMenuType) {
        Menu menu = menuRepository.findByMenuIdAndMenuIsDeletedFalse(menuId).orElseThrow(MenuNotFoundException::new);
        menu.changeMenuPossible();
    }

    @Override
    @Transactional
    public void deleteMenu(Long menuId) {
        Menu menu = menuRepository.findByMenuIdAndMenuIsDeletedFalse(menuId).orElseThrow(MenuNotFoundException::new);
        menu.setMenuIsDeleted();
    }
}
