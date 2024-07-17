package com.example.store.service;

import com.example.store.dao.OptionListDAOImpl;
import com.example.store.dto.request.OptionListRequestDTO;
import com.example.store.dto.response.OptionListResponse;
import com.example.store.global.entity.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OptionListServiceImpl implements OptionListService {



    private final OptionListDAOImpl optionListDAO;


    @Override
    public List<OptionListResponse> getOptionListsByMenuId(Long menuId) {
        List<OptionListResponse> byId = optionListDAO.findByMenuId(menuId);
        if (byId.isEmpty()) {
            throw  new IllegalArgumentException("not found");

        }
        return byId;
    }

    @Override
    public OptionListResponse getOptionListById(Long id) {

        OptionListResponse byId = optionListDAO.findById(id);
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



        optionListDAO.save(optionList);

    }

    @Override
    public void deleteOptionList(Long id) {
        OptionListResponse byId = optionListDAO.findById(id);
        if (byId == null) {
            throw  new IllegalArgumentException("not found");
        }

        optionListDAO.deleteById(id);

    }

    @Override
    public void updateOptionList(Long id, OptionListRequestDTO optionList) {
        OptionListResponse byId = optionListDAO.findById(id);
        if (byId == null) {
            throw  new IllegalArgumentException("Option List not found");
        }
        optionListDAO.save(optionList);

    }




}
