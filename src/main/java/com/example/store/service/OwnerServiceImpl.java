package com.example.store.service;
import com.example.store.dto.kafka.KafkaOwnerDto;
import com.example.store.dto.kafka.KafkaStatus;
import com.example.store.dto.request.OwnerRequestDto;
import com.example.store.dto.request.UpdateOwnerRequestDto;
import com.example.store.dto.response.OwnerResponse;
import com.example.store.global.entity.Owner;
import com.example.store.global.exception.OwnerAlreadyExistsException;
import com.example.store.global.exception.OwnerNotFoundException;
import com.example.store.global.repository.OwnerRepository;
import com.example.store.global.type.UpdateOwnerType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;

    // 삭제 된 거는 조회가 안 되게끔
    @KafkaListener(topics = "owner-info-request-to-store-topic",groupId="store-group")
    @Override
    @Transactional
    public void createOwner(KafkaStatus<KafkaOwnerDto> kafkaStatus) {
        if(kafkaStatus.status().equals("owner_info_to_store")) {
            Owner entity = new OwnerRequestDto(kafkaStatus.data().ownerId(), kafkaStatus.data().ownerName(), kafkaStatus.data().ownerBusinessNumber()).toEntity();
            ownerRepository.save(entity);
        }
    }

    @Override
    @Transactional
    public OwnerResponse getOwnerByOwnerId(Long ownerId) {
        Owner owner = ownerRepository.findByOwnerIsDeletedFalseAndOwnerId(ownerId).orElseThrow(OwnerNotFoundException::new);
        return OwnerResponse.from(owner);
    }

    @Override
    public List<OwnerResponse> getAllOwner() {
        List<Owner> allByOwnerIsDeletedFalse = ownerRepository.findAllByOwnerIsDeletedFalse();
        return allByOwnerIsDeletedFalse.stream().map(OwnerResponse::from).toList();
    }

    @Override
    @Transactional
    public void updateOwner(Long ownerId, UpdateOwnerType updateOwnerType, UpdateOwnerRequestDto updateOwnerRequestDto) {
        Owner owner = ownerRepository.findByOwnerIsDeletedFalseAndOwnerId(ownerId).orElseThrow(OwnerNotFoundException::new);
        owner.update(updateOwnerType, updateOwnerRequestDto);
    }

    @Override
    @Transactional
    public void deleteOwner(Long ownerId) {
        Owner owner = ownerRepository.findByOwnerIsDeletedFalseAndOwnerId(ownerId).orElseThrow(OwnerNotFoundException::new);
        owner.setOwnerIsDeleted();
    }
}
