package com.example.store.global.entity;

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
@Table(name ="OPTION_LIST")
@Builder
@Setter
public class OptionList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LIST_ID")
    private Long optionId;

    @Column(name = "LIST_NAME")
    private String listName;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "addOnList", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Option> options;

    @JsonManagedReference
    @OneToMany(mappedBy = "optionList")
    private List<Option> options;

    @JsonBackReference
    @JoinColumn(name = "MENU_ID")
    @ManyToOne
    private Menu menu;
}
