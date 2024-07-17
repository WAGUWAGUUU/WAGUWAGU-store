package com.example.store.dto.request;

import com.example.store.global.entity.Option;

public record UpdateOptionRequestDTO(
        String optionTitle, int optionPrice
) {
    public Option toEntity() {
        return Option.builder().optionTitle(optionTitle).optionPrice(optionPrice).build();
    }
}
