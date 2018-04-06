package com.goosun.glass.service;

import java.util.List;

import com.goosun.glass.domain.User;

public interface UserService {
	public List<User> getUserInfo();

	public void insert(User user);
}
