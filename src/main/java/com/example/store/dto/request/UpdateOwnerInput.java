package com.example.store.dto.request;

public record UpdateOwnerInput(
        Long ownerId,String type,String value
) {
}
