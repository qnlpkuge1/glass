package com.goosun.glass.service.user;

import com.goosun.glass.domain.User;

public interface UserService {
	
	

	public User get(Long id);
	
	public User add(User user);
	
	public User getByUsername(String username);
	
	public boolean lockUser(Long id);
	
	public boolean unlockUser(Long id);
	
	
	
	
}
