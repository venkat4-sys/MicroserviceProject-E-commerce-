package com.ait.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemsEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String skuCode;
	
	private Double price;
	
	private Integer quantity;
	
	

}
