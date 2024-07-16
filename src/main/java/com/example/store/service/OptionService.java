package com.example.store.service;

import com.example.store.dto.request.OptionRequestDTO;
import com.example.store.dto.response.OptionResponseDTO;
import com.example.store.global.entity.Option;

import java.util.Optional;

public interface OptionService {

    public OptionResponseDTO getOptionById(Long id);
    public void saveOption(OptionRequestDTO option);
    public void deleteOptionById(Long id);
    public void  updateOptionById(Long id, OptionRequestDTO optionRequestDTO);
}
