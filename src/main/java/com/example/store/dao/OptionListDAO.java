package com.example.store.dao;
import com.example.store.dto.request.OptionListRequestDTO;

import com.example.store.dto.request.UpdateOptionListNameRequest;
import com.example.store.dto.request.OptionListRequestDTORevised;
import com.example.store.dto.request.UpdateOptionListRequestDTO;

import com.example.store.global.entity.Menu;
import com.example.store.global.entity.OptionList;

import java.util.List;

public interface OptionListDAO {



    List<OptionList> findByMenuId(Long menuId);
    void save(OptionListRequestDTO optionList);
    void deleteById(Long id);
    OptionList findById(Long id);

    Menu findMenuById(Long id);
    void updateOptionList(Long listId, UpdateOptionListRequestDTO requestDTO);


    void updateOptionListName(Long listId, UpdateOptionListNameRequest updateOptionListNameRequest);
    void saveV2(Menu menu, OptionListRequestDTORevised req);
}
