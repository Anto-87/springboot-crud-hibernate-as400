package com.islandpacific.microservices.demo.mapper;

import com.islandpacific.microservices.demo.dto.StoreDto;
import com.islandpacific.microservices.demo.entity.Store;

public class StoreMapper {
    
    public static Store mapToStore(StoreDto storeDto){
        Store store = new Store(
            storeDto.getId(),
            storeDto.getStoreName(),
            storeDto.getAddressLine1(),
            storeDto.getAddressLine2(),
            storeDto.getCityId(),
            storeDto.getStateId(),
            storeDto.getZipCode()

        );

        return store;
    }


    public static StoreDto mapToStoreDto(Store store){

        StoreDto dto = new StoreDto(
            store.getId(),
            store.getStoreName(),
            store.getAddressLine1(),
            store.getAddressLine2(),
            store.getCityId(),
            store.getStateId(),
            store.getZipCode()

        );

        return dto;
    }
}
