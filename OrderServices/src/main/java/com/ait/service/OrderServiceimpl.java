package com.ait.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ait.dto.InventoryResponse;
import com.ait.dto.OrderItems;
import com.ait.dto.OrderRequest;
import com.ait.entity.OrderEntity;
import com.ait.entity.OrderItemsEntity;
import com.ait.repo.OrderRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceimpl implements OrderService {

	@Autowired
	private OrderRepo orderrepo;
	
	public static final String inventoryUrl="http://localhost:8083/api/inventory/skucode";

	@Override
	public void placeOrder(OrderRequest orderRequest) {
		
		
		

		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setOrderNumber(UUID.randomUUID().toString());

		List<OrderItemsEntity> orderItemsEntities = mapOrderItems(orderRequest.getOrderItems());
		orderEntity.setOrderItems(orderItemsEntities);
		log.info("placing order is recieved....");
		
		//getting all the skucodes
		List<String> skucodes = orderItemsEntities.stream().map(orderItems->orderItems.getSkuCode()).collect(Collectors.toList());
		
		
		WebClient webclient = WebClient.create();
		
		 InventoryResponse[] inventoryresponse = webclient.get()
		         .uri(inventoryUrl,uri->uri.queryParam("skuCode", skucodes).build())
		         .retrieve()
		         .bodyToMono(InventoryResponse[].class)
		         .block();

		boolean status = Arrays.stream(inventoryresponse).allMatch(InventoryResponse::isInStock);
		
		if(status) {
			orderrepo.save(orderEntity);
		}else {
			throw new IllegalArgumentException("Product not in stock please try again later");
		}

	}

	

	private List<OrderItemsEntity> mapOrderItems(List<OrderItems> orderItems) {
		List<OrderItemsEntity> orderItemsEntities = new ArrayList<>();

		for (OrderItems orderItem : orderItems) {
			OrderItemsEntity orderItemsEntity = new OrderItemsEntity();
			orderItemsEntity.setSkuCode(orderItem.getSkuCode());
			orderItemsEntity.setPrice(orderItem.getPrice());
			orderItemsEntity.setQuantity(orderItem.getQuantity());

			// You may set other properties if needed

			orderItemsEntities.add(orderItemsEntity);
		}

		return orderItemsEntities;
	}

}
