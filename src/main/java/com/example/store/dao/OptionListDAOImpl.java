package com.example.store.dao;


import com.example.store.dto.request.OptionListRequestDTO;

import com.example.store.dto.request.UpdateOptionListNameRequest;
import com.example.store.dto.request.OptionListRequestDTORevised;
import com.example.store.dto.request.UpdateOptionListRequestDTO;

import com.example.store.global.entity.Menu;
import com.example.store.global.entity.Option;
import com.example.store.global.entity.OptionList;
import com.example.store.global.exception.MenuNotFoundException;
import com.example.store.global.exception.OptionListNotFoundException;
import com.example.store.global.repository.MenuRepository;
import com.example.store.global.repository.OptionListRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class OptionListDAOImpl implements OptionListDAO {


    private final OptionListRepository optionListRepository;
    private final MenuRepository menuRepository;




    public List<OptionList> findByMenuId(Long menuId){
        return optionListRepository.findByMenuId(menuId);

    };


//    public void save(OptionListRequestDTO optionList) {
//        Menu menu = menuRepository.findById(optionList.menuId()).orElseThrow(MenuNotFoundException::new);
//
//        OptionList optionList1 = optionList.toEntity(menu);
//
//        System.out.println(optionList1.getOptions().get(0).toString());
//        optionListRepository.save(optionList1);
//    }

    @Override
    public void save(OptionList optionList) {
        optionListRepository.save(optionList);
    }

    public void deleteById(Long id) {
        optionListRepository.deleteById(id);
    }


    @Override

    public OptionList findById(Long id) {


        Optional<OptionList> byId = optionListRepository.findById(id);
        if (byId.isEmpty()) {
              throw new OptionListNotFoundException();
        }

        return byId.get();

    }
//    @Override
//    public OptionList findById(Long id) {
//        return optionListRepository.findById(id);
//    }

    @Override
    public Menu findMenuById(Long id) {

        return menuRepository.findById(id).orElseThrow(MenuNotFoundException::new);
    }

    @Override
    public void updateOptionList(Long id, UpdateOptionListRequestDTO updateOptionListRequestDTO) {

        OptionList byId = optionListRepository.findById(id).orElseThrow(OptionListNotFoundException::new);

        String listName = updateOptionListRequestDTO.listName();
        List<Option> options = updateOptionListRequestDTO.options();
        byId.setListName(listName);
        byId.setOptions(options);
        optionListRepository.save(byId);
    }

    @Override
    public void updateOptionListName(Long listId, UpdateOptionListNameRequest updateOptionListNameRequest) {
        OptionList byId = optionListRepository.findById(listId).orElseThrow(OptionListNotFoundException::new);

        String listName = updateOptionListNameRequest.value();
        byId.setListName(listName);
        optionListRepository.save(byId);
    }

    public void saveV2(Menu menu, OptionListRequestDTORevised req) {
        OptionList optionsList = req.toEntity(menu);
        optionListRepository.save(optionsList);
    }
}
