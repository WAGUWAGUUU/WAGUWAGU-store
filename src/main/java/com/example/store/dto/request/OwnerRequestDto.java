package com.example.store.dto.request;

import com.example.store.global.entity.Owner;

public record OwnerRequestDto(
        Long ownerId, String ownerEmail, String ownerName, String ownerBusinessNumber
) {
    public Owner toEntity() {
        return Owner.builder()
                .ownerId(ownerId)
                .ownerEmail(ownerEmail)
                .ownerName(ownerName)
                .ownerBusinessNumber(ownerBusinessNumber)
                .ownerIsDeleted(false)
                .build();
    }
}
