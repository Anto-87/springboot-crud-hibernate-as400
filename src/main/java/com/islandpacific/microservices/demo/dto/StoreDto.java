package com.islandpacific.microservices.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class StoreDto {
    
    private int id;
    private String storeName;
    private String addressLine1;
    private String addressLine2;
    private int cityId;
    private int stateId; 
    private String zipCode;


}
