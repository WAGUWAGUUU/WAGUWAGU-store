package com.example.store.global.repository;

import com.example.store.global.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OptionRepository extends JpaRepository<Option, Long> {
    @Query("SELECT o FROM Option o WHERE o.optionList.listId = :listId")
    List<Option> findByOptionListId(@Param("listId") Long listId);
}
