package com.example.store.dto.response;


import com.example.store.dto.dto.OptionDTO;

import com.example.store.global.entity.Option;

import com.example.store.global.entity.OptionList;

import java.util.List;
import java.util.stream.Collectors;

public record OptionListResponse(Long listId, String listName, List<OptionResponse> options) {
    public static OptionListResponse from(OptionList optionList) {
        List<OptionResponse> optionResponses = optionList.getOptions().stream()
                .map(OptionResponse::from)
                .collect(Collectors.toList());
        return new OptionListResponse(optionList.getListId(), optionList.getListName(), optionResponses);
    }
}