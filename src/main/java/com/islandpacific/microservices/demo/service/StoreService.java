package com.islandpacific.microservices.demo.service;

import java.util.List;

import com.islandpacific.microservices.demo.dto.StoreDto;
import com.islandpacific.microservices.demo.entity.Store;

public interface StoreService {
    
    StoreDto createStore(StoreDto storeDto);
    StoreDto getStoreById(Integer id);
    List<StoreDto> getAllStores();
    void deleteStore(Integer id);
    StoreDto updateStore(Integer id, String addressLine1, String addressLine2);
}
