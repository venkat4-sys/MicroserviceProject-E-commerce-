package com.ait.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ait.dto.InventoryResponse;
import com.ait.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryRest {

	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/skucode")
	public List<InventoryResponse> checkStatus(@RequestParam List<String> skuCode) {

		return inventoryService.isInstock(skuCode);

	}

}
