package com.example.store.controller;

import com.example.store.dto.request.OptionRequestDTO;
import com.example.store.dto.request.UpdateOptionRequestDTO;
import com.example.store.dto.response.OptionResponseDTO;
import com.example.store.service.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/options")
@RequiredArgsConstructor
public class OptionController {

    private final OptionService optionService;




    @GetMapping("/{id}")
    public ResponseEntity<OptionResponseDTO> getOptionById(@PathVariable Long id) {
        OptionResponseDTO option = optionService.getOptionById(id);
        return ResponseEntity.ok(option);
    }

    @GetMapping("/list/{listId}")
    public ResponseEntity<List<OptionResponseDTO>> getAllOptionsByListId(@PathVariable Long listId) {
        List<OptionResponseDTO> options = optionService.getAllOptionsbyListID(listId);
        return ResponseEntity.ok(options);
    }

    @PostMapping
    public ResponseEntity<Void> addOption(@RequestBody OptionRequestDTO optionRequestDTO) {
        optionService.addOption(optionRequestDTO);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOptionById(@PathVariable Long id) {
        optionService.deleteOptionById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOptionById(@PathVariable Long id, @RequestBody UpdateOptionRequestDTO updateOptionRequestDTO) {
        optionService.updateOptionById(id, updateOptionRequestDTO);
        return ResponseEntity.noContent().build();
    }



}
