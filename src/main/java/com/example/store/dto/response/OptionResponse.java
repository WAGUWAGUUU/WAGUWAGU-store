package com.example.store.dto.response;

import com.example.store.global.entity.Option;




public record OptionResponse(
         String optionTitle,int optionPrice,boolean isChecked
) {
    public static OptionResponse from(Option option) {
        return new OptionResponse(option.getOptionTitle(), option.getOptionPrice(),option.isChecked());
    }
}
