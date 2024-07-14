package com.example.store.controller;

import com.example.store.global.entity.Option;
import com.example.store.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/options")
public class OptionController {

    @Autowired
    private OptionService optionService;


    @GetMapping("/list/{listId}")
    public Optional<Option> getAllOptionsByListId(@PathVariable Long listId) {
        return optionService.getAllOptionsbyListId(listId);

    }

    @GetMapping("/{id}")
    public Optional<Option> getOptionById(@PathVariable Long id) {
        return Optional.ofNullable(optionService.getOptionById(id));
    }


    @PostMapping
    public Option createOption(@RequestBody Option option) {
        return optionService.saveOption(option);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Option> updateOption(@PathVariable Long id, @RequestBody Option optionDetails) {
        Optional<Option> option = Optional.ofNullable(optionService.getOptionById(id));
        if (option.isPresent()) {
            optionDetails.setOptionId(id);  // Ensure the ID is set correctly
            optionService.updateOptionById(id, optionDetails);
            return ResponseEntity.ok(optionDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOption(@PathVariable Long id) {
        if (optionService.getOptionById(id) != null) {
            optionService.deleteOptionById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
