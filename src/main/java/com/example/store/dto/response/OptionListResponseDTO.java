package com.example.store.dto.response;

import com.example.store.global.entity.Option;
import com.example.store.global.entity.OptionList;

import java.util.List;

public record OptionListResponseDTO (
        String listName, List<Option> options

){
    public static OptionListResponseDTO from(OptionList optionList) {
        return new OptionListResponseDTO(optionList.getListName(),optionList.getOptions());
    }
}
