package com.example.store.controller;

import com.example.store.dto.request.OptionRequestDTO;
import com.example.store.dto.request.UpdateOptionRequestDTO;
import com.example.store.dto.response.OptionResponse;
import com.example.store.service.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/options")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
public class OptionController {

    private final OptionService optionService;


    @GetMapping("/{id}")
    public ResponseEntity<OptionResponse> getOptionById(@PathVariable Long id) {
        OptionResponse option = optionService.getOptionById(id);
        return ResponseEntity.ok(option);
    }

    @GetMapping("/list/{listId}")
    public ResponseEntity<List<OptionResponse>> getAllOptionsByListId(@PathVariable Long listId) {
        List<OptionResponse> options = optionService.getAllOptionsbyListID(listId);
        return ResponseEntity.ok(options);
    }

    @PostMapping("/list/{listId}")
    public ResponseEntity<Void> addOption(@PathVariable Long listId, @RequestBody OptionRequestDTO optionRequestDTO) {
        optionService.addOption(listId, optionRequestDTO);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOptionById(@PathVariable(name = "id") Long id) {
        optionService.deleteOptionById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOptionById(@PathVariable(name="id") Long id, @RequestBody UpdateOptionRequestDTO updateOptionRequestDTO) {
        optionService.updateOptionById(id, updateOptionRequestDTO);
        return ResponseEntity.noContent().build();
    }





}
