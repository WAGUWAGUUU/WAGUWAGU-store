package com.example.store.controller;

import com.example.store.dto.request.OptionRequestDTO;
import com.example.store.dto.request.UpdateOptionRequestDTO;
import com.example.store.dto.response.OptionResponse;
import com.example.store.global.entity.Option;
import com.example.store.global.repository.OptionRepository;
import com.example.store.service.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/options")
@RequiredArgsConstructor

//@CrossOrigin(origins = "*")
public class OptionController {

    private final OptionService optionService;
    private final OptionRepository optionRepository;

// graphql  prac
    @QueryMapping
    public Option getById(@Argument Long optionId) {
        return optionService.getById(optionId);
    }

    @QueryMapping
    public List<OptionResponse> options(@Argument Long listId) {
        return optionService.getAllOptionsbyListID(listId);
    }

    @MutationMapping
    public Option addOption(@Argument  Long listId , @Argument OptionRequestDTO option ){

        return optionService.addOption(listId,option);
    }

    @MutationMapping
    public Option updateOption(@Argument Long optionId , @Argument UpdateOptionRequestDTO option ){
        return optionService.updateOptionById(optionId,option);
    }


    @MutationMapping
    public Option deleteOption(@Argument Long optionId ){

        return optionService.deleteOptionById(optionId);
    }

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

//    @PostMapping("/list/{listId}")
//    public ResponseEntity<Void> addOption(@PathVariable("listId") Long listId, @RequestBody OptionRequestDTO optionRequestDTO) {
//        optionService.addOption(listId, optionRequestDTO);
//        return ResponseEntity.status(201).build();
//    }

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
