package com.example.store.controller;

import com.example.store.global.entity.OptionList;
import com.example.store.service.OptionListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/optionLists")
public class OrderListCotroller {

    @Autowired
    private OptionListServiceImpl optionListService;

    @GetMapping("/menu/{menuId}")
    public ResponseEntity<OptionList> getOptionListsByMenuId(@PathVariable Long menuId) {
        Optional<OptionList> optionLists = optionListService.getOptionListsByMenuId(menuId);
        return optionLists.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OptionList> getOptionListById(@PathVariable Long id) {
        Optional<OptionList> optionList = optionListService.getOptionListById(id);
        return optionList.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OptionList> createOptionList(@RequestBody OptionList optionList) {
        OptionList savedOptionList = optionListService.saveOptionList(optionList);
        return ResponseEntity.ok(savedOptionList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OptionList> updateOptionList(@PathVariable Long id, @RequestBody OptionList optionListDetails) {
        Optional<OptionList> optionList = optionListService.getOptionListById(id);
        if (optionList.isPresent()) {
            optionListDetails.setOptionId(id);  // Ensure the ID is set correctly
            optionListService.updateOptionList(id, optionListDetails);
            return ResponseEntity.ok(optionListDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOptionList(@PathVariable Long id) {
        if (optionListService.getOptionListById(id).isPresent()) {
            optionListService.deleteOptionList(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
