package com.example.store.dto.response;

import com.example.store.global.entity.Owner;

public record OwnerResponse(
        String ownerName, String ownerBusinessNumber
){
    public static OwnerResponse from(Owner owner) {
        return new OwnerResponse(owner.getOwnerName(), owner.getOwnerBusinessNumber());
    }
}
