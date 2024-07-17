package com.example.store.service;

import com.example.store.dto.request.OptionListRequestDTO;
import com.example.store.dto.request.UpdateOptionListRequestDTO;
import com.example.store.dto.response.OptionListResponse;

import java.util.List;


public interface OptionListService {
     List<OptionListResponse> getOptionListsByMenuId(Long menuId);
     OptionListResponse getOptionListById(Long id);
     void createOptionList(OptionListRequestDTO optionList);
     void deleteOptionList(Long id);
     void updateOptionList(Long id, UpdateOptionListRequestDTO optionList);

}
