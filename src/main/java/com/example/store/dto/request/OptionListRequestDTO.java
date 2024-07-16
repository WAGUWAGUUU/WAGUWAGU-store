package com.example.store.dto.request;

import com.example.store.global.entity.Menu;
import com.example.store.global.entity.Option;
import com.example.store.global.entity.OptionList;

import java.util.List;

public record OptionListRequestDTO(
        Long listId,Long menuId, String  listName, List<Option> options
) {
    public OptionList toEntity(Menu menu){

        return OptionList.builder().listId(listId).listName(listName).options(options).menu(menu).build();



    }
}
