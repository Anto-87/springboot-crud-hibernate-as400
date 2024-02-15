package com.islandpacific.microservices.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.islandpacific.microservices.demo.entity.Store;

// Enables CRUD operation for store table 
public interface StoreRepository extends JpaRepository<Store, Integer> {
    
}
