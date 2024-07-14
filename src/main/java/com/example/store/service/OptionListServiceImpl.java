package com.example.store.service;

import com.example.store.global.entity.OptionList;
import com.example.store.global.repository.OptionListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OptionListServiceImpl implements OptionListService {

    @Autowired
    private OptionListRepository optionListRepository;

    @Override
    public Optional<OptionList> getOptionListsByMenuId(Long menuId) {

        return optionListRepository.findById(menuId);
    }

    @Override
    public Optional<OptionList> getOptionListById(Long id) {
        return optionListRepository.findById(id);
    }

    @Override
    public OptionList saveOptionList(OptionList optionList) {
        return optionListRepository.save(optionList);
    }

    @Override
    public void deleteOptionList(Long id) {
        optionListRepository.deleteById(id);
    }

    @Override
    public void updateOptionList(Long id, OptionList optionList) {
        Optional<OptionList> byId = optionListRepository.findById(id);
        if (byId.isPresent()) {
            optionListRepository.save(optionList);
        }
    }


}
