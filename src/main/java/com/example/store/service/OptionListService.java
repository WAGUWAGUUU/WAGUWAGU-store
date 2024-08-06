package com.example.store.service;

import com.example.store.dto.request.OptionListRequestDTO;

import com.example.store.dto.request.UpdateOptionListNameRequest;
import com.example.store.dto.request.OptionListRequestDTORevised;
import com.example.store.dto.request.UpdateOptionListRequestDTO;

import com.example.store.dto.response.OptionListResponse;
import com.example.store.dto.response.OptionListResponseRevised;

import java.util.List;


public interface OptionListService {
     List<OptionListResponse> getOptionListsByMenuId(Long menuId);
     OptionListResponse getOptionListById(Long id);
     void createOptionList(OptionListRequestDTO optionList);
     void deleteOptionList(Long id);
     void updateOptionList(Long id, UpdateOptionListRequestDTO optionList);

     void updateOptionListName(Long id, UpdateOptionListNameRequest updateOptionListNameRequest);

     void createOptionListV2(OptionListRequestDTORevised req);
     List<OptionListResponseRevised> getOptionListsByMenuIdV2(Long menuId);
     List<OptionListResponse> getOptionListsByStoreId(Long storeId);
}
