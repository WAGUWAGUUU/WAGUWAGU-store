package com.example.store.dto.request;

import com.example.store.global.entity.Option;
import com.example.store.global.entity.OptionList;

public record OptionRequestDTO(
        // option list id 삭제 (pathVariable로 받아옴)
        String optionTitle, int optionPrice, boolean isChecked
) {

    public Option toEntity(OptionList optionList) {
        return Option.builder()
                .optionList(optionList)
                .optionTitle(optionTitle)
                .optionPrice(optionPrice)
                .isChecked(isChecked).build();
    }
}
