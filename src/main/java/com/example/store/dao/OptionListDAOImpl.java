package com.example.store.dao;


import com.example.store.dto.request.OptionListRequestDTO;
import com.example.store.dto.request.UpdateOptionListRequestDTO;
import com.example.store.dto.response.OptionListResponseDTO;
import com.example.store.global.entity.Menu;
import com.example.store.global.entity.Option;
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



    public List<OptionList> findByMenuId(Long menuId){
        return optionListRepository.findByMenuId(menuId);

    };


    public void save(OptionListRequestDTO optionList) {
        Menu menu = menuRepository.findById(optionList.menuId())
                .orElseThrow(() -> new IllegalArgumentException("Menu not found"));

        OptionList optionList1 = optionList.toEntity(menu);


        optionListRepository.save(optionList1);
    }


    public void deleteById(Long id) {
        optionListRepository.deleteById(id);
    }


    @Override
    public OptionList findById(Long id) {
        Optional<OptionList> byId = optionListRepository.findById(id);
        if (byId.isEmpty()) {
              throw new  IllegalArgumentException("OptionList not found");
        }
        return byId.get();
    }

    @Override
    public Menu findMenuById(Long id) {

        return menuRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Menu not found"));
    }

    @Override
    public void updateOptionList(Long id, UpdateOptionListRequestDTO updateOptionListRequestDTO) {

        OptionList byId = optionListRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("OptionList not found"));

        String listName = updateOptionListRequestDTO.listName();
        List<Option> options = updateOptionListRequestDTO.options();
        byId.setListName(listName);
        byId.setOptions(options);
        optionListRepository.save(byId);



    }


}
