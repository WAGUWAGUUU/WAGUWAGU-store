package com.example.store.service;

import com.example.store.dao.OptionListDAOImpl;
import com.example.store.dto.request.OptionListRequestDTO;

import com.example.store.dto.request.UpdateOptionListNameRequest;
import com.example.store.dto.request.OptionListRequestDTORevised;
import com.example.store.dto.request.UpdateOptionListRequestDTO;

import com.example.store.dto.response.OptionListResponse;
import com.example.store.dto.response.OptionListResponseRevised;
import com.example.store.global.entity.Menu;
import com.example.store.global.entity.OptionList;
import com.example.store.global.exception.OptionListNotFoundException;
import jakarta.transaction.Transactional;
import com.example.store.global.exception.MenuNotFoundException;
import com.example.store.global.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OptionListServiceImpl implements OptionListService {

    private final OptionListDAOImpl optionListDAO;
    private final MenuRepository menuRepository;


    @Override
    public OptionList getListById(Long id) {

        return optionListDAO.findById(id);
    }

    @Override
    public List<OptionList> OptionLists(Long menuId) {
        return optionListDAO.findByMenuId(menuId);
    }

//    @Override
//    public List<OptionListResponse> getOptionListsByMenuId(Long menuId) {
//
//        List<OptionList> optionLists = optionListDAO.findByMenuId(menuId);
//        System.out.println("Fetched option lists: " + optionLists);
//        return optionLists.stream()
//                .map(OptionListResponse::from)
//                .collect(Collectors.toList());
//    }


    @Override
    public List<OptionListResponse> getOptionListsByMenuId(Long menuId) {
        List<OptionList> optionLists = optionListDAO.findByMenuId(menuId);
        if (optionLists.isEmpty()) {
            throw new OptionListNotFoundException();
        }
        return optionLists.stream()
                .map(OptionListResponse::from)
                .collect(Collectors.toList());
    }
    @Override
    public OptionListResponse getOptionListById(Long id) {


        OptionList list  = optionListDAO.findById(id);
        if (list == null) {

       

            throw  new OptionListNotFoundException();
        }

        return OptionListResponse.from(list);
    }

    @Override
    public void createOptionList(OptionListRequestDTO optionList) {
        Menu menuById = optionListDAO.findMenuById(optionList.menuId());
        if (menuById == null) {
            throw  new MenuNotFoundException();
        }
        System.out.println(optionList.options());
        optionListDAO.save(optionList);

    }

    @Override
    public void deleteOptionList(Long id) {

        OptionList byId = optionListDAO.findById(id);

        if (byId == null) {
            throw  new OptionListNotFoundException();
        }

        optionListDAO.deleteById(id);

    }

    @Override

    public void updateOptionList(Long id, UpdateOptionListRequestDTO optionList) {
            optionListDAO.updateOptionList(id,optionList);
    }

    @Override

    @Transactional
    public void updateOptionListName(Long id, UpdateOptionListNameRequest updateOptionListNameRequest) {
        optionListDAO.updateOptionListName(id, updateOptionListNameRequest);
    }

    public void createOptionListV2(OptionListRequestDTORevised req) {
        Menu menu = menuRepository.findByMenuIdAndMenuIsDeletedFalse(req.menuId()).orElseThrow(MenuNotFoundException::new);
        optionListDAO.saveV2(menu, req);
    }

    @Override
    public List<OptionListResponseRevised> getOptionListsByMenuIdV2(Long menuId) {
        List<OptionList> byId = optionListDAO.findByMenuId(menuId);
        if (byId.isEmpty()) throw new OptionListNotFoundException();
        return byId.stream()
                .map(OptionListResponseRevised::from)
                .collect(Collectors.toList());}

}
