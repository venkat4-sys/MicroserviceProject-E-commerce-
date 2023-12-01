package com.ait.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ait.dto.ProductRequest;
import com.ait.dto.ProductResponse;
import com.ait.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductRest {
	
	@Autowired
	private ProductService productservice;
	
	@PostMapping("/createProduct")
	public ResponseEntity<?> createProducts(@RequestBody ProductRequest productrequest) {
		
		productservice.createProduct(productrequest);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/allproducts")
	public ResponseEntity<List<ProductResponse>> getAllProducts(){
		 
		return new ResponseEntity<List<ProductResponse>>(productservice.getAllProducts(),HttpStatus.OK);
	}

}
