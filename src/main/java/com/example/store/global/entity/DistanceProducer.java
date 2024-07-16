package com.example.store.global.entity;

import com.example.store.dto.kafka.KafkaDistanceDto;
import com.example.store.dto.kafka.KafkaStatus;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DistanceProducer {
    private final KafkaTemplate<String, KafkaStatus<KafkaDistanceDto>> kafkaTemplateForDistance;

    @Bean
    public NewTopic distanceTopic() {
        return new NewTopic("delivery-request-topic", 1, (short) 1);
    }

    public void sendToRider(KafkaDistanceDto kafkaDistanceDto, String status) {
        KafkaStatus<KafkaDistanceDto> kafkaStatus = new KafkaStatus<>(kafkaDistanceDto, status);
        kafkaTemplateForDistance.send("delivery-request-topic", kafkaStatus);
    }
}
