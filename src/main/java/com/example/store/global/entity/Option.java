package com.example.store.global.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "OPTIONS")
@Builder
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPTION_ID")
    private Long optionId;

    @Column(name = "OPTION_TITLE")
    @Setter
    private String optionTitle;
    @Setter
    @Column(name = "OPTION_PRICE")
    private int optionPrice;

    @Column(name = "OPTION_CHECKED")
    private boolean isChecked = false;



    @JoinColumn(name = "OPTION_LIST_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @Setter
    private OptionList optionList;
}
