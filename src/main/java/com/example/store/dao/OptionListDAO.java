package com.example.store.dao;
import com.example.store.dto.request.OptionListRequestDTO;
import com.example.store.dto.response.OptionListResponse;
import com.example.store.global.entity.Menu;

import java.util.List;

public interface OptionListDAO {

    List<OptionListResponse> findByMenuId(Long menuId);
    void save(OptionListRequestDTO optionList);
    void deleteById(Long id);
    OptionListResponse findById(Long id);
    Menu findMenuById(Long id);

}
