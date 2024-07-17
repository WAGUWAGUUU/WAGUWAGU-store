package com.example.store.global.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="OPTION_LIST")
@Builder
@Setter
public class OptionList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPTION_LIST_ID")
    private Long listId;

    @Column(name = "OPTION_LIST_NAME")
    private String listName;


    @OneToMany(mappedBy = "optionList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Option> options;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID")
    private Menu menu;


}
