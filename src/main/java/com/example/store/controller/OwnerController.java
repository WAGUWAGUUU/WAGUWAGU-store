package com.example.store.controller;
import com.example.store.dto.request.OwnerRequestDto;
import com.example.store.dto.request.UpdateOwnerRequestDto;
import com.example.store.dto.response.OwnerResponse;
import com.example.store.global.type.UpdateOwnerType;
import com.example.store.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/owner")
@RequiredArgsConstructor
public class OwnerController {
    private final OwnerService ownerService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOwner(@RequestBody OwnerRequestDto ownerRequestDto) {
        ownerService.createOwner(ownerRequestDto);
    }

    @GetMapping("/{ownerId}")
    @ResponseStatus(HttpStatus.OK)
    public OwnerResponse getOwnerByOwnerId(@PathVariable(name = "ownerId") Long ownerId) {
        return ownerService.getOwnerByOwnerId(ownerId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OwnerResponse> getAllOwner() {
        return ownerService.getAllOwner();
    }


    @PutMapping("/{ownerId}/owner-name")
    @ResponseStatus(HttpStatus.OK)
    public void updateOwnerName(@PathVariable(name = "ownerId") Long ownerId, @RequestBody UpdateOwnerRequestDto updateOwnerRequestDto) {
        ownerService.updateOwner(ownerId, UpdateOwnerType.OWNER_NAME, updateOwnerRequestDto);
    }

    @PutMapping("/{ownerId}/owner-business-number")
    @ResponseStatus(HttpStatus.OK)
    public void updateOwnerBusinessNumber(@PathVariable(name = "ownerId") Long ownerId, @RequestBody UpdateOwnerRequestDto updateOwnerRequestDto) {
        ownerService.updateOwner(ownerId, UpdateOwnerType.OWNER_BUSINESS_NUMBER, updateOwnerRequestDto);
    }

    @DeleteMapping("/{ownerId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOwner(@PathVariable(name = "ownerId") Long ownerId) {
        ownerService.deleteOwner(ownerId);
    }

}
