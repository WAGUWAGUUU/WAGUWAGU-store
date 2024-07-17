package com.example.store.dto.dto;

import com.example.store.global.entity.Option;




public record OptionDTO(Long optionId, String optionTitle, int optionPrice) {
    public static OptionDTO from(Option option) {
        return new OptionDTO(option.getOptionId(), option.getOptionTitle(), option.getOptionPrice());
    }
}

