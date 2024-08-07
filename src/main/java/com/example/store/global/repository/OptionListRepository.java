package com.example.store.global.repository;

import com.example.store.global.entity.OptionList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OptionListRepository extends JpaRepository<OptionList, Long> {
//    @Query("SELECT ol FROM OptionList ol WHERE ol.menu.menuId = :menuId")
//    List<OptionList> findByMenuId(@Param("menuId") Long menuId);
    @Query("SELECT ol FROM OptionList ol " +
            "JOIN MenuOptionListBridge molb ON ol.listId = molb.optionList.listId " +
            "WHERE molb.menu.menuId = :menuId")
    List<OptionList> findByMenuId(@Param("menuId") Long menuId);
    List<OptionList> findByListName(String listName);
}
