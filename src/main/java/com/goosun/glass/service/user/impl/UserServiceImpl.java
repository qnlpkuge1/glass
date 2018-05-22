package com.goosun.glass.service.user.impl;

import java.util.Date;

import com.goosun.glass.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goosun.glass.dao.user.UserDao;
import com.goosun.glass.domain.User;
import com.goosun.glass.service.ServiceException;
import com.goosun.glass.service.user.UserService;

@Service
@Transactional
public class UserServiceImpl extends BaseService implements UserService{

	@Autowired
	private UserDao userDao;

	

	@Override
	public User getByUsername(String username) {
		return userDao.getByUsername(username);
	}


	@Override
	public User add(User user) {
		
		checkAddUser(user);
		
		user.setCreatedTime(new Date());
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userDao.addUser(user);
		return get(user.getId());
	}


	@Override
	public User get(Long id) {
		return userDao.get(id);
	}
	
	
	private void checkAddUser(User user) {
		
		if (user == null || user.getUsername() == null
				|| "".equals(user.getUsername().trim())) {
			throw new ServiceException("用户名不能为空！");
		}
		
		if (user.getPassword() == null || "".equals(user.getPassword().trim())) {
			throw new ServiceException("密码不能为空！");
		}
		
		if (user.getMobile() == null || "".equals(user.getMobile())) {
			throw new ServiceException("手机号码不能为空");
		}
		
		if (this.getByUsername(user.getUsername()) != null) {
			throw new ServiceException("用户名已存在！");
		}

	}


	@Override
	public boolean lockUser(Long id) {
		return false;
	}


	@Override
	public boolean unlockUser(Long id) {
		return false;
	}

}
