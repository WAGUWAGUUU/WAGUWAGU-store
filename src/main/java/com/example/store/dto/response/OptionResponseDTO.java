package com.example.store.dto.response;

import com.example.store.global.entity.Option;




public record OptionResponseDTO(
         String optionTitle,int optionPrice
) {
    public static OptionResponseDTO from(Option option) {
        return new OptionResponseDTO(option.getOptionTitle(), option.getOptionPrice());
    }
}
