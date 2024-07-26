package com.example.store.dao;

import com.example.store.dto.request.OptionRequestDTO;
import com.example.store.dto.request.UpdateOptionRequestDTO;
import com.example.store.global.entity.Option;
import com.example.store.global.entity.OptionList;
import com.example.store.global.repository.OptionListRepository;
import com.example.store.global.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OptionDAOImpl implements OptionDAO {

     private final OptionRepository optionRepository;
     private final OptionListRepository optionListRepository;

    @Override
    public Option getOptionById(Long id) {
        Optional<Option> byId = optionRepository.findById(id);

        return byId.orElseThrow(() -> new IllegalArgumentException("no option of this id "));
    }

    @Override
    public List<Option> getAllOptionsByListId(Long listId) {
        OptionList optionList = optionListRepository.findById(listId)
                .orElseThrow(() -> new IllegalArgumentException("OptionList not found"));

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
                throw new IllegalArgumentException("Option already exists");
        });
        // 저장
        OptionList optionList = optionListRepository.findById(listId)
                .orElseThrow(() -> new IllegalArgumentException("OptionList not found"));
        optionRepository.save(optionRequestDTO.toEntity(optionList));
    }

    @Override
    public void updateOption(Long id, UpdateOptionRequestDTO optionRequestDTO) {
        Option option = optionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Option not found"));

        option.setOptionTitle(optionRequestDTO.optionTitle());
        option.setOptionPrice(optionRequestDTO.optionPrice());

        optionRepository.save(option);


    }

    @Override
    public void deleteOptionById(Long id) {
        optionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("cannot delete:no option found "));
        optionRepository.deleteById(id);
    }
}
