package com.example.store.service;

import com.example.store.dto.request.OptionRequestDTO;
import com.example.store.dto.response.OptionResponse;
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
    public OptionResponse getOptionById(Long id) {
        Optional<Option> byId = optionRepository.findById(id);
        if (byId.isEmpty()) {
            throw new IllegalArgumentException("Option not found");
        } else {
            return OptionResponse.from(byId.get());
        }

    }

    @Override
    public void saveOption(OptionRequestDTO option) {
       optionRepository.save(option.toEntity(option));

    }

    @Override
    public void deleteOptionById(Long id) {
       optionRepository.deleteById(id);

    }

    @Override
    public void updateOptionById(Long id, OptionRequestDTO optionRequestDTO) {
        Optional<Option> byId = optionRepository.findById(id);
        if (byId.isEmpty()) {throw new IllegalArgumentException("Option not found");}
        else {
            Option option = byId.get();
            optionRepository.delete(option);
        }
    }
}
