package com.example.store.dto.kafka;

import java.time.LocalDateTime;

public record KafkaDistanceDto(
        Long orderId,
        String storeName,
        String storeAddress,
        int deliveryFee,
        double distanceFromStoreToCustomer,
        double storeLatitude,
        double storeLongitude,
        LocalDateTime due
) {
}
