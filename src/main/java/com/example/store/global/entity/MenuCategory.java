package com.example.store.global.entity;

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

    @JsonBackReference
    @JoinColumn(name = "STORE_ID")
    @ManyToOne
    private Store store;

    @JsonManagedReference
    @OneToMany(mappedBy = "menuCategory", cascade = CascadeType.ALL)
    private List<Menu> menus;
}
