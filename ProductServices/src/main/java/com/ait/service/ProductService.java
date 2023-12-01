package com.ait.service;

import java.util.List;

import com.ait.dto.ProductRequest;
import com.ait.dto.ProductResponse;

public interface ProductService {
	
	public void createProduct(ProductRequest productRequest);
	
	public List<ProductResponse> getAllProducts();
	

}
