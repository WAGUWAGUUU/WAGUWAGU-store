package com.example.store.dto.response;

import com.example.store.dto.dto.OptionDTO;
import com.example.store.global.entity.OptionList;

import java.util.List;

public record OptionListResponseDTO (
        String listName,  List<OptionDTO> options

){
    public static OptionListResponseDTO from(OptionList optionList) {
        List<OptionDTO> optionDTOS = optionList.getOptions().stream().map(OptionDTO::from).toList();
        return new OptionListResponseDTO(optionList.getListName(), optionDTOS);
    }
}
