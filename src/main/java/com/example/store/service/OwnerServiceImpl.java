package com.example.store.service;
import com.example.store.dto.request.OwnerRequestDto;
import com.example.store.dto.request.UpdateOwnerRequestDto;
import com.example.store.global.entity.Owner;
import com.example.store.global.repository.OwnerRepository;
import com.example.store.global.type.UpdateOwnerType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;

    @Override
    @Transactional
    public void createOwner(OwnerRequestDto ownerRequestDto) {
        Optional<Owner> byOwnerBusinessNumber = ownerRepository.findByOwnerBusinessNumber(ownerRequestDto.ownerBusinessNumber());
        if(byOwnerBusinessNumber.isPresent()) throw new IllegalArgumentException();
        Owner toEntity = ownerRequestDto.toEntity();
        ownerRepository.save(toEntity);
    }

    @Override
    @Transactional
    public Owner getOwnerByOwnerId(Long ownerId) {
        return ownerRepository.findById(ownerId).orElseThrow();
    }

    @Override
    public List<Owner> getAllOwner() {
        return ownerRepository.findAll();
    }

    @Override
    @Transactional
    public void updateOwner(Long ownerId, UpdateOwnerType updateOwnerType, UpdateOwnerRequestDto updateOwnerRequestDto) {
        Owner owner = ownerRepository.findById(ownerId).orElseThrow();
        owner.update(updateOwnerType, updateOwnerRequestDto);
    }

    @Override
    @Transactional
    public void deleteOwner(Long ownerId) {
        Owner owner = ownerRepository.findById(ownerId).orElseThrow();
        owner.setOwnerIsDeleted();
    }


}
