package com.example.store.service;

import com.example.store.dto.request.OptionRequestDTO;
import com.example.store.dto.request.UpdateOptionRequestDTO;
import com.example.store.dto.response.OptionResponseDTO;
import com.example.store.global.entity.Option;

import java.util.List;
import java.util.Optional;

public interface OptionService {

     OptionResponseDTO getOptionById(Long id);
     List<OptionResponseDTO> getAllOptionsbyListID(Long id);
     void addOption(OptionRequestDTO option);
     void deleteOptionById(Long id);
     void  updateOptionById(Long id, UpdateOptionRequestDTO optionRequestDTO);
}
