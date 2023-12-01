package com.ait.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ait.dto.OrderRequest;
import com.ait.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderRest {
	
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/placeorder")
	public ResponseEntity<?> placeOrder(@RequestBody OrderRequest request) {
		orderService.placeOrder(request);
		
		return new ResponseEntity<>("order placed successfully", HttpStatus.CREATED);
	}

}
