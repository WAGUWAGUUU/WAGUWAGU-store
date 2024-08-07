package com.example.store.global.entity;

import com.example.store.dto.request.UpdateMenuCategoryRequestDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="MENU_CATEGORIES")
@Builder
public class MenuCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_CATEGORY_ID")
    private Long menuCategoryId;

    @Column(name = "MENU_CATEGORY_NAME")
    private String menuCategoryName;

    @Column(name = "MENU_CATEGORY_IS_DELETED")
    private boolean menuCategoryIsDeleted;


    @JoinColumn(name = "STORE_ID")
    @ManyToOne
    private Store store;

    @OneToMany(mappedBy = "menuCategory")
    private List<Menu> menus;

    public void updateMenuCategoryName(UpdateMenuCategoryRequestDto updateMenuCategoryRequestDto) {
        this.menuCategoryName = updateMenuCategoryRequestDto.value();
    }

    public void setMenuCategoryIsDeleted() {
        this.menuCategoryIsDeleted = true;
    }
}
