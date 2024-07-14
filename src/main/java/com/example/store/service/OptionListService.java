package com.example.store.service;

import com.example.store.global.entity.OptionList;

import java.util.Optional;

public interface OptionListService {
    public Optional<OptionList> getOptionListsByMenuId(Long menuId);
    public Optional<OptionList> getOptionListById(Long id);
    public OptionList saveOptionList(OptionList optionList);
    public void deleteOptionList(Long id);

}
