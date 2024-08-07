package com.example.store.dto.response;

import com.example.store.global.entity.Option;

public record OptionResponse(Long optionId, String optionTitle, int optionPrice) {
    public static OptionResponse from(Option option) {
        return new OptionResponse(option.getOptionId(), option.getOptionTitle(), option.getOptionPrice());
    }
}
