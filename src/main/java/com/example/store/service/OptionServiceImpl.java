package com.example.store.service;

import com.example.store.dao.OptionDAO;
import com.example.store.dto.request.OptionRequestDTO;

import com.example.store.dto.request.UpdateOptionRequestDTO;

import com.example.store.dto.response.OptionResponse;
import com.example.store.global.entity.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OptionServiceImpl implements OptionService {



    private final OptionDAO optionDAO;


    @Override
    public Option getOptionById(long optionId) {
        return null;
    }
// graphql prac
    @Override
    public Option getById(Long id) {
        return optionDAO.getById(id);
    }

    @Override
    public OptionResponse getOptionById(Long id) {

        Option optionById = optionDAO.getOptionById(id);
        return  OptionResponse.from(optionById);



    }

    @Override
    public List<OptionResponse> getAllOptionsbyListID(Long id) {
        List<Option> options = optionDAO.getAllOptionsByListId(id);

        return options.stream()
                .map(OptionResponse::from)
                .collect(Collectors.toList());
    }

    @Override
    public Option addOption(Long listId, OptionRequestDTO option) {
       optionDAO.addOption(listId, option);
        return null;
    }

    @Override
    public Option deleteOptionById(Long id) {
       optionDAO.deleteOptionById(id);

        return null;
    }

    @Override
    public Option updateOptionById(Long id, UpdateOptionRequestDTO optionRequestDTO) {
       optionDAO.updateOption(id,optionRequestDTO);

        return null;
    }
}
