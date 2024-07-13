package com.example.store.service;
import com.example.store.dto.request.MenuRequestDto;
import com.example.store.global.entity.Menu;
import com.example.store.global.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;
    @Override
    public void createMenu(MenuRequestDto menuRequestDto) {
        Optional<Menu> byMenuCategoryAndMenuName = menuRepository.findByMenuCategoryAndMenuName(menuRequestDto.menuCategory(), menuRequestDto.menuName());
        if(byMenuCategoryAndMenuName.isPresent()) throw new IllegalArgumentException();
        Menu entity = menuRequestDto.toEntity();
        menuRepository.save(entity);
    }
}
