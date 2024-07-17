package com.example.store.dto.response;

import com.example.store.dto.dto.OptionDTO;
import com.example.store.global.entity.OptionList;

import java.util.List;

public record OptionListResponse(
        String listName,  List<OptionDTO> options

){
    public static OptionListResponse from(OptionList optionList) {
        List<OptionDTO> optionDTOS = optionList.getOptions().stream().map(OptionDTO::from).toList();
        return new OptionListResponse(optionList.getListName(), optionDTOS);
    }
}
