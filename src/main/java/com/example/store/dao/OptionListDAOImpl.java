package com.example.store.dao;


import com.example.store.dto.request.OptionListRequestDTO;
import com.example.store.dto.response.OptionListResponseDTO;
import com.example.store.global.entity.Menu;
import com.example.store.global.entity.OptionList;
import com.example.store.global.repository.MenuRepository;
import com.example.store.global.repository.OptionListRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
@RequiredArgsConstructor
public class OptionListDAOImpl implements OptionListDAO {

    private final OptionListRepository optionListRepository;
    private final MenuRepository menuRepository;



    public List<OptionListResponseDTO> findByMenuId(Long menuId){
        return optionListRepository.findByMenuId(menuId).stream()
                .map(OptionListResponseDTO::from)
                .collect(Collectors.toList());

    };



    public void save(OptionListRequestDTO optionList) {
       optionListRepository.save(optionList.toEntity(Menu.builder().build()));
    }

    public void deleteById(Long id) {
        optionListRepository.deleteById(id);
    }

    @Override
    public OptionListResponseDTO findById(Long id) {
        Optional<OptionList> byId = optionListRepository.findById(id);
        if (byId.isEmpty()) {
              throw new  IllegalArgumentException("OptionList not found");
        }
        return OptionListResponseDTO.from(byId.get());
    }

    @Override
    public Menu findMenuById(Long id) {
        Menu byID = menuRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Menu not found"));

        return byID;
    }
}
