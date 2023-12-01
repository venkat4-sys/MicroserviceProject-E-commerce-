package com.ait.service;

import java.util.List;

import com.ait.dto.InventoryResponse;

public interface InventoryService {
	
	public List<InventoryResponse> isInstock(List<String> skucode);

}
