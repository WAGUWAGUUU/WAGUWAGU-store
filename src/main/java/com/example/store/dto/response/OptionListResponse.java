package com.example.store.dto.response;

import com.example.store.global.entity.Option;
import com.example.store.global.entity.OptionList;

import java.util.List;

public record OptionListResponse(
        String listName, List<Option> options

){
    public static OptionListResponse from(OptionList optionList) {
        return new OptionListResponse(optionList.getListName(),optionList.getOptions());
    }
}
