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
@Setter
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPTION_ID")
    private Long optionId;

    @Column(name = "OPTION_TITLE")
    private String optionTitle;

    @Column(name = "OPTION_PRICE")
    private int optionPrice;




    @JoinColumn(name = "OPTION_LIST_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private OptionList optionList;
}
