package com.example.store.controller;
import com.example.store.dto.kafka.KafkaCustomerDto;
import com.example.store.dto.kafka.KafkaOwnerDto;
import com.example.store.dto.kafka.KafkaStatus;
import com.example.store.dto.request.OwnerRequestDto;
import com.example.store.dto.request.UpdateOwnerRequestDto;
import com.example.store.dto.response.OwnerResponse;
import com.example.store.global.type.UpdateOwnerType;
import com.example.store.global.type.UpdateStoreType;
import com.example.store.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/owner")
@RequiredArgsConstructor
public class OwnerController {
    private final OwnerService ownerService;

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public void createOwner() {
//        ownerService.createOwner();
//    }

    @GetMapping("/{ownerId}")
    public OwnerResponse getOwnerByOwnerId(@PathVariable(name = "ownerId") Long ownerId) {
        return ownerService.getOwnerByOwnerId(ownerId);
    }

    @GetMapping
    public List<OwnerResponse> getAllOwner() {
        return ownerService.getAllOwner();
    }


    @PutMapping("/{ownerId}")
    public void updateOwner(@PathVariable(name = "ownerId") Long ownerId,@RequestParam(name = "type")String type, @RequestBody UpdateOwnerRequestDto updateOwnerRequestDto) {
        ownerService.updateOwner(ownerId,  UpdateOwnerType.stringToOwnerType(type), updateOwnerRequestDto);
    }

    @DeleteMapping("/{ownerId}")
    public void deleteOwner(@PathVariable(name = "ownerId") Long ownerId) {
        ownerService.deleteOwner(ownerId);
    }

}
