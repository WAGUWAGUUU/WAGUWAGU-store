package com.example.store.service;

import com.example.store.dto.request.OptionRequestDTO;
import com.example.store.dto.response.OptionResponse;

public interface OptionService {

    public OptionResponse getOptionById(Long id);
    public void saveOption(OptionRequestDTO option);
    public void deleteOptionById(Long id);
    public void  updateOptionById(Long id, OptionRequestDTO optionRequestDTO);
}
