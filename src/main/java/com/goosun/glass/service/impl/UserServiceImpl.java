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
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User insert(User user) {
		int id = userDao.addUserInfo(user);
		return get(id);
	}


	@Override
	public User get(int id) {
		return userDao.get(id);
	}

}
