package com.example.store.dto.request;

import com.example.store.global.entity.Menu;
import com.example.store.global.entity.OptionList;

//
public record OptionListRequestDTORevised(
        Long menuId, String listName
) {
    public OptionList toEntity(Menu menu){
        OptionList optionList = OptionList.builder()
                .listName(listName)
//                .menu(menu)
                .build();
        return optionList;
    }
}
