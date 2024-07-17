package com.example.store.dto.request;

import com.example.store.global.entity.Option;
import com.example.store.global.entity.OptionList;

public record OptionRequestDTO(
        Long optionId,Long listId ,String optionTitle, int optionPrice
) {

    public Option toEntity(OptionList optionList) {

        return Option.builder().optionId(optionId).optionList(optionList).optionTitle(optionTitle).optionPrice(optionPrice).build();

    }
}
