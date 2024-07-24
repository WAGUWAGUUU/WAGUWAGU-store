package com.example.store.dto.request;

import com.example.store.global.entity.Option;
import com.example.store.global.entity.OptionList;

import java.util.List;

public record UpdateOptionListRequestDTO(
         String listName, List<Option> options
) {
    public OptionList toEntity() {

        return OptionList.builder().listName(listName).options(options).build();

    }
}
