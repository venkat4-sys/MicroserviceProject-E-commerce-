package com.ait.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

	private Integer id;

	private String productName;

	private String productDescription;

	private Double productPrice;

}
