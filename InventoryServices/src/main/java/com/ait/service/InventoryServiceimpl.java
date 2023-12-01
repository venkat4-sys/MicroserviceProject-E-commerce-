package com.ait.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.dto.InventoryResponse;
import com.ait.entity.Inventory;
import com.ait.repo.InventoryRepo;

@Service
public class InventoryServiceimpl implements InventoryService{
	
	@Autowired
	private InventoryRepo inventoryRepo;

	@Override
	public List<InventoryResponse> isInstock(List<String> skucode) {
		List<InventoryResponse> responseList = new ArrayList<>();
		List<Inventory> listofinventories = inventoryRepo.findBySkuCodeIn(skucode);
		for (Inventory inventory : listofinventories) {
			InventoryResponse response = new InventoryResponse();
			response.setSkuCode(inventory.getSkuCode());
			response.setInStock(inventory.getQuantity() > 0);
			responseList.add(response);
		}

		return responseList;
	}

		



}
