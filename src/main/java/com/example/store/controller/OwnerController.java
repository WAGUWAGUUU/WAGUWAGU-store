package com.example.store.controller;
import com.example.store.dto.kafka.KafkaCustomerDto;
import com.example.store.dto.kafka.KafkaOwnerDto;
import com.example.store.dto.kafka.KafkaStatus;
import com.example.store.dto.request.OwnerRequestDto;
import com.example.store.dto.request.UpdateOwnerInput;
import com.example.store.dto.request.UpdateOwnerRequestDto;
import com.example.store.dto.response.OwnerResponse;
import com.example.store.global.entity.Owner;
import com.example.store.global.type.UpdateOwnerType;
import com.example.store.global.type.UpdateStoreType;
import com.example.store.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/owner")
@RequiredArgsConstructor
public class OwnerController {
    private final OwnerService ownerService;

    @QueryMapping
    public OwnerResponse getOwnerByOwnerId(@Argument(name = "ownerId") Long ownerId) {
        return ownerService.getOwnerByOwnerId(ownerId);
    }

    @QueryMapping
    public List<OwnerResponse> getAllOwner() {
        return ownerService.getAllOwner();
    }


    @MutationMapping
    public void updateOwner(@Argument(name = "input") UpdateOwnerInput input) {
        ownerService.updateOwner(input.ownerId(),  UpdateOwnerType.stringToOwnerType(input.type()), input.value());
    }

    @MutationMapping
    public void deleteOwner(@Argument(name = "ownerId") Long ownerId) {
        ownerService.deleteOwner(ownerId);
    }

}
