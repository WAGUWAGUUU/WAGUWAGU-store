package com.example.store.global.entity;

import com.example.store.dto.request.UpdateOwnerRequestDto;
import com.example.store.global.type.UpdateOwnerType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="OWNERS")
@Builder
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OWNER_ID")
    private Long ownerId;

    @Column(name = "OWNER_NAME")
    private String ownerName;

    @Column(name = "OWNER_BUSINESS_NUMBER")
    private String ownerBusinessNumber;

    @Column(name = "OWNER_IS_DELETED")
    private boolean ownerIsDeleted;

//    @OneToMany(mappedBy = "owner")
//    private List<Store> store;



    public void update(UpdateOwnerType updateOwnerType, UpdateOwnerRequestDto updateOwnerRequestDto) {
        switch (updateOwnerType) {
            case OWNER_NAME:
                this.ownerName = updateOwnerRequestDto.value();
                break;
            case OWNER_BUSINESS_NUMBER:
                this.ownerBusinessNumber = updateOwnerRequestDto.value();
                break;
        }
    }

    public void setOwnerIsDeleted() {
        this.ownerIsDeleted = true;
    }
}
