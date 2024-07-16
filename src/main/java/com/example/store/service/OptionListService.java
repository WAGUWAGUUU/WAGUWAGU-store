package com.example.store.service;

import com.example.store.dto.request.OptionListRequestDTO;
import com.example.store.dto.response.OptionListResponseDTO;
import com.example.store.global.entity.OptionList;

import java.util.List;
import java.util.Optional;

//OPTIONAL 반환 X DAO에서처리
public interface OptionListService {
     List<OptionListResponseDTO> getOptionListsByMenuId(Long menuId);
     OptionListResponseDTO getOptionListById(Long id);
     void createOptionList(OptionListRequestDTO optionList);
     void deleteOptionList(Long id);
     void updateOptionList(Long id, OptionListRequestDTO optionList);

}
