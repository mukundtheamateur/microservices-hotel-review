package com.cts.user.services;

import java.util.List;

import com.cts.user.entities.User;

public interface UserService {

	User saveUser(User user);
	List<User> getAllUser();
	User getUser(String userId);
}
