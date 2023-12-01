package com.ait.dto;

import lombok.Data;


@Data
public class ProductRequest {
	
    private String productName;
	
	private String productDescription;
	
	private Double productPrice;

}
