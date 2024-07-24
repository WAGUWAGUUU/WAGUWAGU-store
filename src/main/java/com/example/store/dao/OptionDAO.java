package com.example.store.dao;

import com.example.store.dto.request.OptionRequestDTO;
import com.example.store.dto.request.UpdateOptionRequestDTO;
import com.example.store.global.entity.Option;

import java.util.List;

public interface OptionDAO {

    Option getOptionById(Long id);
    List<Option> getAllOptionsByListId(Long listId);
    void addOption(OptionRequestDTO optionRequestDTO);
    void updateOption(Long id, UpdateOptionRequestDTO optionRequestDTO);
    void deleteOptionById(Long id);


}
