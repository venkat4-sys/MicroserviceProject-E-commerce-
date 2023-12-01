package com.ait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer>{

}
