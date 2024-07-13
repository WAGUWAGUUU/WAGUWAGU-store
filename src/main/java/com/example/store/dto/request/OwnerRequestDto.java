package com.example.store.dto.request;

import com.example.store.global.entity.Owner;

public record OwnerRequestDto(
        String ownerName, String ownerBusinessNumber
) {
    public Owner toEntity() {
        return Owner.builder()
                .ownerName(ownerName)
                .ownerBusinessNumber(ownerBusinessNumber)
                .ownerIsDeleted(false)
//                .store(null)
                .build();
    }
}
