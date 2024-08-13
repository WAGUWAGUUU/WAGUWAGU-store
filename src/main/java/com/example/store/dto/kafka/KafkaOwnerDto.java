package com.example.store.dto.kafka;

public record KafkaOwnerDto(
        Long ownerId,
        String ownerEmail,
        String ownerName,
        String ownerBusinessNumber
) {
}
