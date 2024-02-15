package com.islandpacific.microservices.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.islandpacific.microservices.demo.dto.StoreDto;
import com.islandpacific.microservices.demo.entity.Store;
import com.islandpacific.microservices.demo.mapper.StoreMapper;
import com.islandpacific.microservices.demo.repository.StoreRepository;
import com.islandpacific.microservices.demo.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

    private StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }
    
    @Override
    public StoreDto createStore(StoreDto storeDto) {
        
        Store savedStore = StoreMapper.mapToStore(storeDto);
        Store newRecord = storeRepository.save(savedStore);
        return StoreMapper.mapToStoreDto(newRecord);

    }

    @Override
    public StoreDto getStoreById(Integer id) {
        Store store =  storeRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Store not exists!!"));
       return StoreMapper.mapToStoreDto(store);
    }

    @Override
    public List<StoreDto> getAllStores() {
        List<Store> allStores  = storeRepository.findAll();
        return allStores.stream().map((store) -> StoreMapper.mapToStoreDto(store) )
                    .collect(Collectors.toList());
            
    }

    @Override
    public void deleteStore(Integer id) {
       
        Store store =  storeRepository
                     .findById(id)
                    .orElseThrow(() -> new RuntimeException("Store not exists!!"));

        storeRepository.deleteById(id);            

    }

    @Override
    public StoreDto updateStore(Integer id, String addressLine1, String addressLine2) {
       
        Store store =  storeRepository
                         .findById(id)
                            .orElseThrow(() -> new RuntimeException("Store not exists!!"));

        store.setAddressLine1(addressLine1);
        store.setAddressLine2(addressLine2);
        Store newRecord = storeRepository.save(store);
        return StoreMapper.mapToStoreDto(newRecord);

    }
    
    
}
