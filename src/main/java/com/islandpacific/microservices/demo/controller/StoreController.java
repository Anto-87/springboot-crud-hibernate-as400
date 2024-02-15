package com.islandpacific.microservices.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.islandpacific.microservices.demo.dto.StoreDto;
import com.islandpacific.microservices.demo.service.StoreService;

import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/stores")
public class StoreController {

    private StoreService storeService;

    public StoreController(StoreService storeService){
        this.storeService = storeService;
    }

    // ADD stores 
    @PostMapping("/add")
    public ResponseEntity<StoreDto> addStore(@RequestBody StoreDto storeDto){        
        return new ResponseEntity<>(storeService.createStore(storeDto), HttpStatus.CREATED);
    }
    
    // Get store by ID 
    @GetMapping("/{id}")
    public ResponseEntity<StoreDto> getStoreById(@PathVariable Integer id){
        StoreDto storeDto = storeService.getStoreById(id);
        return ResponseEntity.ok(storeDto);
    }

    // Get all stores
    @GetMapping
    public  ResponseEntity<List<StoreDto>> getAllStores(){
        List<StoreDto> allStores =  storeService.getAllStores();
        return ResponseEntity.ok(allStores);
    }

    // Delete store by ID 
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStore(@PathVariable Integer id){
        storeService.deleteStore(id);
        return ResponseEntity.ok("Store is deleted !!");
    }

    // Update the stores by address_line_1 & address_line_2
    @PutMapping("/{id}/update")
    public  ResponseEntity<StoreDto> updateStores(@PathVariable Integer id, @RequestBody Map<String, String> request){

        StoreDto storeDto = storeService.updateStore(id, request.get("addressLine1"), request.get("addressLine2"));
        return ResponseEntity.ok(storeDto);


    }
}
