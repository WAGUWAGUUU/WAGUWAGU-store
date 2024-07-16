package com.example.store.service;

import com.example.store.dao.OptionListDAOImpl;
import com.example.store.dto.request.OptionListRequestDTO;
import com.example.store.dto.response.OptionListResponseDTO;
import com.example.store.dto.response.OptionResponseDTO;
import com.example.store.global.entity.Menu;
import com.example.store.global.entity.OptionList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OptionListServiceImpl implements OptionListService {



    private final OptionListDAOImpl optionListDAO;


    @Override
    public List<OptionListResponseDTO> getOptionListsByMenuId(Long menuId) {
        List<OptionListResponseDTO> byId = optionListDAO.findByMenuId(menuId);
        if (byId.isEmpty()) {
            throw  new IllegalArgumentException("not found");

        }
        return byId;
    }

    @Override
    public OptionListResponseDTO getOptionListById(Long id) {

        OptionListResponseDTO byId = optionListDAO.findById(id);
        if (byId == null) {
            throw  new IllegalArgumentException("not found");
        }

        return byId;
    }

    @Override
    public void createOptionList( OptionListRequestDTO optionList) {
        Menu menuById = optionListDAO.findMenuById(optionList.menuId());
        if (menuById == null) {
            throw  new IllegalArgumentException("menu not found");
        }
        OptionListResponseDTO byId = optionListDAO.findById(optionList.listId());
        if (byId ==null) {
            throw  new IllegalArgumentException("LIST ID not found");
        }



        optionListDAO.save(optionList);

    }

    @Override
    public void deleteOptionList(Long id) {
        OptionListResponseDTO byId = optionListDAO.findById(id);
        if (byId == null) {
            throw  new IllegalArgumentException("not found");
        }

        optionListDAO.deleteById(id);

    }

    @Override
    public void updateOptionList(Long id, OptionListRequestDTO optionList) {
        OptionListResponseDTO byId = optionListDAO.findById(id);
        if (byId == null) {
            throw  new IllegalArgumentException("Option List not found");
        }
        optionListDAO.save(optionList);

    }




}
