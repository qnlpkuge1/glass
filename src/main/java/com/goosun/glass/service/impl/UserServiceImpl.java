package com.goosun.glass.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goosun.glass.dao.UserDao;
import com.goosun.glass.domain.User;
import com.goosun.glass.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getUserInfo() {
		return userDao.findUserInfo();
	}

	@Override
	public void insert(User user) {
		userDao.addUserInfo(user);
	}

}
