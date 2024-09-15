package com.learn.graphql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.graphql.entity.Order;
import com.learn.graphql.entity.User;
import com.learn.graphql.helper.ExceptionHelper;
import com.learn.graphql.repository.OrderRepository;

@Service
public class OrderService {

	
	@Autowired
	OrderRepository orderRepository;
	
	
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}
	
	
	public List<Order> getAllOrders(){
		return orderRepository.findAll();
	}
	
	public Order getSingleOrder(int orderId) {

		Order order = orderRepository.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
		return order;
	}
	
	
//	public Order getOrderByUserId(int userId) {
//		
//		return	orderRepository.getOrderByUserId(userId);
//		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
