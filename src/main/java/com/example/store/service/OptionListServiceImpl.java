package com.example.store.service;

import com.example.store.dao.OptionListDAOImpl;
import com.example.store.dto.request.OptionListRequestDTO;

import com.example.store.dto.request.UpdateOptionListNameRequest;
import com.example.store.dto.request.OptionListRequestDTORevised;
import com.example.store.dto.request.UpdateOptionListRequestDTO;

import com.example.store.dto.response.OptionListResponse;
import com.example.store.dto.response.OptionListResponseRevised;
import com.example.store.global.entity.*;
import com.example.store.global.exception.OptionListNotFoundException;
import com.example.store.global.exception.StoreNotFoundException;
import com.example.store.global.repository.MenuOptionListBridgeRepository;
import com.example.store.global.repository.OptionListRepository;
import com.example.store.global.repository.StoreRepository;
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
    private final MenuOptionListBridgeRepository optionListBridgeRepository;
    private final MenuOptionListBridgeRepository menuOptionListBridgeRepository;
    private final StoreRepository storeRepository;
    private final OptionListRepository optionListRepository;


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

        List<OptionList> byId = optionListDAO.findByMenuId(menuId);

      
        if (byId.isEmpty()) {
            throw  new OptionListNotFoundException();

        }

          return byId.stream()
                .map(OptionListResponse::from)
                .collect(Collectors.toList());
    }

//    @Override
//    public OptionListResponse getOptionListById(Long id) {
//
//
//        OptionList list  = optionListDAO.findById(id);
//        if (list == null) {
//
//
//
//            throw  new OptionListNotFoundException();
//        }
//
//        return OptionListResponse.from(list);
//    }
    @Override
    public OptionListResponse getOptionListById(Long id) {
        OptionList optionList = optionListDAO.findById(id)
                .orElseThrow(OptionListNotFoundException::new);
        return OptionListResponse.from(optionList);
    }

    @Override
    public void createOptionList(OptionListRequestDTO optionListDTO) {
        Menu menu = menuRepository.findById(optionListDTO.menuId())
                .orElseThrow(MenuNotFoundException::new);

        // Create or update OptionList entity
        OptionList optionList = optionListDAO.findById(optionListDTO.listId())
                .orElse(OptionList.builder()
                        .listId(optionListDTO.listId())
                        .listName(optionListDTO.listName())
                        .build());

        // Clear existing options and add new ones
        optionList.getOptions().clear();
        for (var optionDTO : optionListDTO.options()) {
            Option option = Option.builder()
                    .optionTitle(optionDTO.getOptionTitle())
                    .optionPrice(optionDTO.getOptionPrice())
                    .optionList(optionList)
                    .build();
            optionList.addOption(option);
        }

        // Save or update OptionList
        optionListDAO.save(optionList);

        // Create or update MenuOptionListBridge
        MenuOptionListBridge bridge = MenuOptionListBridge.builder()
                .menu(menu)
                .optionList(optionList)
                .build();
        menuOptionListBridgeRepository.save(bridge);
    }



    @Override
    public void deleteOptionList(Long id) {

        OptionList byId = optionListDAO.findById(id)
                .orElseThrow(OptionListNotFoundException::new);

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
                .collect(Collectors.toList());
    }

    @Override
    public List<OptionListResponse> getOptionListsByStoreId(Long storeId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(StoreNotFoundException::new);

        List<OptionList> optionLists = store.getMenuCategories().stream()
                .flatMap(menuCategory -> menuCategory.getMenus().stream())
                .flatMap(menu -> optionListRepository.findByMenuId(menu.getMenuId()).stream())
                .collect(Collectors.toList());

        if (optionLists.isEmpty()) {
            throw new OptionListNotFoundException();
        }

        return optionLists.stream()
                .map(OptionListResponse::from)
                .collect(Collectors.toList());
    }
}
