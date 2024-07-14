package com.example.store.global.repository;

import com.example.store.global.entity.OptionList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OptionListRepository extends JpaRepository<OptionList, Long> {
}
