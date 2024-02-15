package com.islandpacific.microservices.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="stores")
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="store_id")
    private int id;

    @Column(name="store_name")
    private String storeName;

    @Column(name="address_line_1")
    private String addressLine1;

    @Column(name="address_line_2")
    private String addressLine2;

    @Column(name="city_id")
    private int cityId;

    @Column(name="state_id")
    private int stateId; 

    @Column(name="zip_code")
    private String zipCode;

    
}
