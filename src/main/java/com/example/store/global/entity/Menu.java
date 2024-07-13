package com.example.store.global.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="MENUS")
@Builder
@Setter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_ID")
    private Long menuId;

    @Column(name = "MENU_NAME")
    private String menuName;

    @Column(name = "MENU_INTRODUCTION")
    private String menuIntroduction;

    @Column(name = "MENU_PRICE")
    private int menuPrice;

    @Column(name = "MENU_POSSIBLE")
    private boolean menuPossible;

    @JsonBackReference
    @JoinColumn(name = "MENU_CATEGORY_ID")
    @ManyToOne
    private MenuCategory menuCategory;
}
