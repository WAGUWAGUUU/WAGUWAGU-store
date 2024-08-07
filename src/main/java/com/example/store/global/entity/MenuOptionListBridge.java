package com.example.store.global.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="MENU_OPTION_LIST_BRIDGE")
@Builder
public class MenuOptionListBridge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRIDGE_ID")
    private Long bridgeId;

    @JoinColumn(name = "MENU_ID")
    @ManyToOne
    private Menu menu;

    @JoinColumn(name = "OPTION_LIST_ID")
    @ManyToOne
    private OptionList optionList;
}
