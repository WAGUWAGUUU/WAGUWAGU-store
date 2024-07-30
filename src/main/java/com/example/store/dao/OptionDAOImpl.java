package com.example.store.dao;

import com.example.store.dto.request.OptionRequestDTO;
import com.example.store.dto.request.UpdateOptionRequestDTO;
import com.example.store.global.entity.Option;
import com.example.store.global.entity.OptionList;
import com.example.store.global.exception.OptionAlreadyExistsException;
import com.example.store.global.exception.OptionListNotFoundException;
import com.example.store.global.exception.OptionNotFoundException;
import com.example.store.global.repository.OptionListRepository;
import com.example.store.global.repository.OptionRepository;
//import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OptionDAOImpl implements OptionDAO
//        , GraphQLQueryResolver
{

     private final OptionRepository optionRepository;
     private final OptionListRepository optionListRepository;

// GRAPHQL PRAC
     @Override
     public Option getById(long id) {
         return optionRepository.findById(id).orElse(null);
     }

    @Override
    public Option getOptionById(Long id) {
        Optional<Option> byId = optionRepository.findById(id);

        return byId.orElseThrow(OptionNotFoundException::new);
    }

    @Override
    public List<Option> getAllOptionsByListId(Long listId) {
        OptionList optionList = optionListRepository.findById(listId)
                .orElseThrow(OptionListNotFoundException::new);

//        List<Option> options = optionRepository.findByOptionListId(listId);
//        options.forEach(option -> option.setOptionList(optionList));

        return optionList.getOptions();
    }

    @Override
    public void addOption(Long listId, OptionRequestDTO optionRequestDTO) {
        // 이미 존재하면 exception 띄움
        List<Option> options = optionRepository
                .findByOptionList_ListId(listId);
        options.forEach(el -> {
            if (el.getOptionTitle().equals(optionRequestDTO.optionTitle()))
                throw new OptionAlreadyExistsException();
        });
        // 저장
        OptionList optionList = optionListRepository.findById(listId)
                .orElseThrow(OptionListNotFoundException::new);
        optionRepository.save(optionRequestDTO.toEntity(optionList));
    }

    @Override
    public void updateOption(Long id, UpdateOptionRequestDTO optionRequestDTO) {
        Option option = optionRepository.findById(id)
                .orElseThrow(OptionNotFoundException::new);

        option.setOptionTitle(optionRequestDTO.optionTitle());
        option.setOptionPrice(optionRequestDTO.optionPrice());

        optionRepository.save(option);


    }

    @Override
    public void deleteOptionById(Long id) {
        optionRepository.findById(id).orElseThrow(OptionNotFoundException::new);
        optionRepository.deleteById(id);
    }
}
