package com.learn.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.learn.graphql.entity.Order;
import com.learn.graphql.entity.User;
import com.learn.graphql.service.OrderService;
import com.learn.graphql.service.UserService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;


	@MutationMapping(name = "createOrder")
	public Order createOrder(@Argument String orderDetails,
			@Argument String orderAddress,
			@Argument int  orderAmount,
			@Argument int userId) {
		System.out.println("Inside createUser");

		User user = userService.getSingleUser(userId);


		Order order = new Order();

		order.setOrderAddress(orderAddress);
		order.setOrderAmount(orderAmount);
		order.setOrderDetails(orderDetails);
		order.setUser(user);


		orderService.createOrder(order);

		return order;

	}


	@QueryMapping(name ="getAllOrders" )
	public List<Order> getAllOrders(){

		return orderService.getAllOrders();
	}


	@QueryMapping(name="getSingleOrder")
	public Order getSingleOrder(@Argument int orderId) {

		return  orderService.getSingleOrder(orderId);

	}
}
