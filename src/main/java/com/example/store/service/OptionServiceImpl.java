package com.example.store.service;

import com.example.store.global.entity.Option;
import com.example.store.global.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OptionServiceImpl implements OptionService {

    @Autowired
    private OptionRepository optionRepository;

    @Override
    public Optional<Option> getAllOptionsbyListId(Long listId) {

        return optionRepository.findById(listId);
    }

    @Override
    public Option getOptionById(Long id) {
        return optionRepository.findById(id).orElse(null);
    }



    @Override
    public Option saveOption(Option option) {
        return optionRepository.save(option);
    }

    @Override
    public void deleteOptionById(Long id) {
        optionRepository.deleteById(id);
    }
}
