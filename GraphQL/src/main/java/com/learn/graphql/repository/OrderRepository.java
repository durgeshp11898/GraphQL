package com.learn.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.graphql.entity.Order;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Integer>{

	//Order getOrderByUserId(int userId);
}
