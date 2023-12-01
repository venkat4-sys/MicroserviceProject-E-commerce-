package com.ait.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.dto.ProductRequest;
import com.ait.dto.ProductResponse;
import com.ait.entity.ProductEntity;
import com.ait.repository.ProductRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceimpl implements ProductService {

	@Autowired
	private ProductRepo productrepo;

	@Override
	public void createProduct(ProductRequest productRequest) {

		log.info("getting the product{} request object" + productRequest);

		ProductEntity entity = new ProductEntity();

		BeanUtils.copyProperties(productRequest, entity);
		productrepo.save(entity);

		log.info("Product {} is saved" + entity.getId());

	}

	@Override
	public List<ProductResponse> getAllProducts() {
		List<ProductResponse> listOfProducts = new ArrayList<>();
		List<ProductEntity> Prodcuts = productrepo.findAll();
		for (ProductEntity list : Prodcuts) {
			ProductResponse response = new ProductResponse();

			BeanUtils.copyProperties(list, response);
			listOfProducts.add(response);

		}
		log.info("getting all the products {} information");
		return listOfProducts;
	}

}
