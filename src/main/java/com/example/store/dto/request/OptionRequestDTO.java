package com.example.store.dto.request;

import com.example.store.global.entity.Option;

public record OptionRequestDTO(
        Long optionId, String optionTitle, int optionPrice
) {

    public Option toEntity(OptionRequestDTO optionRequestDTO) {

        return Option.builder().optionId(optionId).optionTitle(optionTitle).optionPrice(optionPrice).build();

    }
}
