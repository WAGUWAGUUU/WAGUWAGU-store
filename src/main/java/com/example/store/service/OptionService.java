package com.example.store.service;

import com.example.store.global.entity.Option;

import java.util.Optional;

public interface OptionService {
    public Optional<Option> getAllOptionsbyListId(Long listId);
    public Option getOptionById(Long id);
    public Option saveOption(Option option);
    public void deleteOptionById(Long id);

}
