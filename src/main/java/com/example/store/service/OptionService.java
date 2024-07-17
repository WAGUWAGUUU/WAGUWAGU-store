package com.example.store.service;

import com.example.store.dto.request.OptionRequestDTO;
import com.example.store.dto.request.UpdateOptionRequestDTO;
import com.example.store.dto.response.OptionResponse;

import java.util.List;

public interface OptionService {

     OptionResponse getOptionById(Long id);
     List<OptionResponse> getAllOptionsbyListID(Long id);
     void addOption(OptionRequestDTO option);
     void deleteOptionById(Long id);
     void  updateOptionById(Long id, UpdateOptionRequestDTO optionRequestDTO);
}
