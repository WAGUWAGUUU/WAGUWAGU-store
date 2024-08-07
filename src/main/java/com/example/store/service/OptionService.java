package com.example.store.service;

import com.example.store.dto.request.OptionRequestDTO;

import com.example.store.dto.request.UpdateOptionRequestDTO;
import com.example.store.dto.response.OptionResponse;
import com.example.store.global.entity.Option;

import java.util.List;

public interface OptionService {


     Option getOptionById(long optionId);
     Option getById(Long id);
     OptionResponse getOptionById(Long id);
     List<OptionResponse> getAllOptionsbyListID(Long id);
     Option addOption(Long listId, OptionRequestDTO option);
     Option deleteOptionById(Long id);
     Option updateOptionById(Long id, UpdateOptionRequestDTO optionRequestDTO);

}
