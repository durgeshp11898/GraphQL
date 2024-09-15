package com.learn.graphql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.graphql.entity.User;
import com.learn.graphql.helper.ExceptionHelper;
import com.learn.graphql.repository.UserRepository;

@Service
public class UserService {


	@Autowired
	UserRepository repository;


	public User createUser(User user) {
		return repository.save(user);

	}


	public List<User>  getAllUsers() {

		return repository.findAll();
	}


	public User getSingleUser(int userId) {

		User user = repository.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
		return user;
	}


	public boolean deleteUser(int userId) {
		User user = repository.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
		repository.delete(user);
		return true;
	}
}
