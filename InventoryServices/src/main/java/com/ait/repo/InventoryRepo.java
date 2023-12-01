package com.ait.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory, Integer> {

	List<Inventory> findBySkuCodeIn(List<String> skucode);

}

