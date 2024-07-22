package com.example.store.global.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="OPTION_LIST")
@Builder
public class OptionList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPTION_LIST_ID")
    private Long listId;

    @Column(name = "OPTION_LIST_NAME")
    @Setter
    private String listName;

    @Builder.Default
    @OneToMany(mappedBy = "optionList", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private List<Option> options=new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID")
    private Menu menu;

    public void addOption(Option option) {
        option.setOptionList(this);
        options.add(option);
    }

}
