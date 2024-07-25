package com.example.store.dto.response;


import com.example.store.dto.dto.OptionDTO;
import com.example.store.global.entity.OptionList;

import java.util.List;

public record OptionListResponseRevised(

        Long optionListId, String listName

){
    public static OptionListResponseRevised from(OptionList optionList) {
        List<OptionDTO> optionDTOS = optionList.getOptions().stream().map(OptionDTO::from).toList();
        return new OptionListResponseRevised(optionList.getListId(), optionList.getListName());

    }
}
