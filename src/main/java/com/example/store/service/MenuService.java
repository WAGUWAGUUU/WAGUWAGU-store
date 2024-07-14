package com.example.store.service;

import com.example.store.dto.request.MenuRequestDto;
import com.example.store.global.entity.MenuCategory;

import java.util.List;

public interface MenuService {
    void createMenu(MenuRequestDto menuRequestDto);


}
