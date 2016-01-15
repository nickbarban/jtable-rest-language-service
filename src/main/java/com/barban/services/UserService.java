package com.barban.services;

import com.barban.model.User;

public interface UserService {
	Iterable<User> listAllUsers();

	User getUserById(Integer id);

	User saveUser(User user);

	void deleteUser(Integer id);
}