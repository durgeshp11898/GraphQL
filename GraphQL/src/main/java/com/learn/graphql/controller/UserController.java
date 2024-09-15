package com.learn.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.learn.graphql.entity.User;
import com.learn.graphql.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;


	@MutationMapping(name = "createUser")
	public User createUser(@Argument String userName,
			@Argument String userPhone,
			@Argument String userEmail,
			@Argument String userPassword) {
		System.out.println("Inside createUser");
		User user = new User();

		user.setUserName(userName);
		user.setUserEmail(userEmail);
		user.setUserPhone(userPhone);
		user.setUserPassword(userPassword);
		System.out.println("User Deyails: "+user.toString());
		return userService.createUser(user);
	}
	
	
	@QueryMapping(name ="getAllUsers" )
	public List<User> getAllUsers(){
		
		return userService.getAllUsers();
	}
	
	
	@QueryMapping(name="getUserById")
	public User getUserById(@Argument int userId) {
		
		return userService.getSingleUser(userId);
		
	}
}
