package com.example.store.controller;


import com.example.store.dto.request.OptionListRequestDTO;

import com.example.store.dto.request.OptionListRequestDTORevised;
import com.example.store.dto.request.UpdateOptionListRequestDTO;

import com.example.store.dto.response.OptionListResponse;
import com.example.store.dto.response.OptionListResponseRevised;
import com.example.store.service.OptionListServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/option-lists")
//@CrossOrigin(origins = "*")
public class OptionListController {

    private final OptionListServiceImpl optionListService;



    @GetMapping("/menu/{menuId}")
    public ResponseEntity<List<OptionListResponse>> getOptionListsByMenuId(@PathVariable("menuId") Long menuId) {
        List<OptionListResponse> optionLists = optionListService.getOptionListsByMenuId(menuId);
        return new ResponseEntity<>(optionLists, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<OptionListResponse> getOptionListById(@PathVariable Long id) {
        OptionListResponse optionList = optionListService.getOptionListById(id);
        return new ResponseEntity<>(optionList, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Void> createOptionList(@RequestBody OptionListRequestDTO optionListRequestDTO) {
        optionListService.createOptionList(optionListRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOptionList(@PathVariable Long id, @RequestBody UpdateOptionListRequestDTO optionListRequestDTO) {
        optionListService.updateOptionList(id, optionListRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOptionList(@PathVariable Long id) {
        optionListService.deleteOptionList(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/revised")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOptionListV2(@RequestBody OptionListRequestDTORevised req) {
        optionListService.createOptionListV2(req);
    }

    @GetMapping("/menu/{menuId}/revised")
    public List<OptionListResponseRevised> getOptionListsByMenuIdV2(@PathVariable("menuId") Long menuId) {
        List<OptionListResponseRevised> optionLists = optionListService.getOptionListsByMenuIdV2(menuId);
        return optionLists;
    }
}
