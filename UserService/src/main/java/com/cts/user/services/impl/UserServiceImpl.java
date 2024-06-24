package com.cts.user.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.user.entities.User;
import com.cts.user.exceptions.ResourceNotFoundException;
import com.cts.user.repositories.UserRepository;
import com.cts.user.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		log.info("userService saveUser returned successfully");
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		log.info("users list fetched successfully in service");
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		log.info("user with userID fetched successfully");
		return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user with given id can't be found: "+ userId));
	}

}
