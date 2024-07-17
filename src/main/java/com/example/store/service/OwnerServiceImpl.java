package com.example.store.service;
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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;

    // 삭제 된 거는 조회가 안 되게끔 했음
    @Override
    @Transactional
    public void createOwner(OwnerRequestDto ownerRequestDto) {
        Optional<Owner> byOwnerBusinessNumber = ownerRepository.findByOwnerBusinessNumberAndOwnerIsDeletedFalse(ownerRequestDto.ownerBusinessNumber());
        if(byOwnerBusinessNumber.isPresent()) throw new OwnerAlreadyExistsException();
        Owner toEntity = ownerRequestDto.toEntity();
        ownerRepository.save(toEntity);
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
