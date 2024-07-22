package com.example.store.dto.request;

import com.example.store.global.entity.Menu;
import com.example.store.global.entity.Option;
import com.example.store.global.entity.OptionList;

import java.util.List;

public record OptionListRequestDTO(
        Long menuId, String  listName, List<Option> options
) {
    public OptionList toEntity(Menu menu){

        OptionList build = OptionList.builder()
                .listName(listName)
                .menu(menu)
                .build();
        options.forEach(build::addOption);
        return build;



    }
}
