package com.example.store.global.entity;

import com.example.store.dto.request.UpdateMenuRequestDto;
import com.example.store.global.exception.MenuInputException;
import com.example.store.global.type.UpdateMenuType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="MENUS")
@Builder
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

    @Column(name = "MENU_IS_DELETED")
    private boolean menuIsDeleted;

    @JoinColumn(name = "MENU_CATEGORY_ID")
    @ManyToOne
    private MenuCategory menuCategory;

    @Column(name = "MENU_IMAGE")
    private String menuImage;


    @OneToMany(mappedBy = "menu",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenuOptionListBridge> bridges;

    public void update(UpdateMenuType updateMenuType, String value) {
        switch (updateMenuType) {
            case MENU_NAME -> this.menuName = value;
            case MENU_INTRODUCTION -> this.menuIntroduction = value;
            case MENU_PRICE -> {
                try {
                    this.menuPrice = Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    throw new MenuInputException();
                }
            }
            case MENU_IMAGE -> {
                this.menuImage = value;
            }
        }
    }

    public void changeMenuPossible() {
        this.menuPossible = !menuPossible;
    }

    public void setMenuIsDeleted() {
        this.menuIsDeleted = true;
    }
}
