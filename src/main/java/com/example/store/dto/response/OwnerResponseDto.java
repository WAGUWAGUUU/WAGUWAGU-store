package com.example.store.dto.response;

import com.example.store.global.entity.Owner;

public record OwnerResponseDto (
        String ownerName, String ownerBusinessNumber
){
    public static OwnerResponseDto from(Owner owner) {
        return new OwnerResponseDto(owner.getOwnerName(), owner.getOwnerBusinessNumber());
    }
}
