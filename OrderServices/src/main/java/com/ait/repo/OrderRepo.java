package com.ait.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.OrderEntity;

public interface OrderRepo extends JpaRepository<OrderEntity, Integer>{

}
