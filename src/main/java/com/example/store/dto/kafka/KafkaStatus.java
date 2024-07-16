package com.example.store.dto.kafka;

public record KafkaStatus<T>(
        T data, String status
){
}
