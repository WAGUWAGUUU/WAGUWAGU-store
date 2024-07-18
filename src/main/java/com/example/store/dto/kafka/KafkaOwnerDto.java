package com.example.store.dto.kafka;

public record KafkaOwnerDto(
        Long ownerId,
        String ownerName,
        String ownerBusinessNumber
) {
}
