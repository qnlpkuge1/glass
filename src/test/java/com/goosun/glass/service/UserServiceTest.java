package com.goosun.glass.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.goosun.glass.service.user.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.goosun.glass.domain.User;

public class UserServiceTest extends BaseServiceTest {

	@Autowired
	private UserService userService;
	
	
	//@Test
	public void testAddUser() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = "admin123";
		User user=new User();
		user.setUsername("admin");
		user.setPassword(password);
		user.setMobile("15833831123");
		user.setTitle("张三");
		user.setType("default");
		user.setSmallAvatar("smallAvator");
		user.setMediumAvatar("mediumAvatar");
		user.setLargeAvatar("largeAvatar");
		user.setRoles("|ROLE_USER|");
		user.setLoginIp("127.0.0.1");
		user.setLoginSessionId("sdfjsdofow");
		user.setCreatedIp("127.0.0.1");
		User savedUser = userService.add(user);
		assertNotNull(savedUser);
		assertEquals(user.getUsername(), savedUser.getUsername());
		assertTrue(encoder.matches(password,savedUser.getPassword()));
		assertEquals(user.getMobile(), savedUser.getMobile());
		assertEquals(user.getTitle(), savedUser.getTitle());
		assertEquals(user.getType(), savedUser.getType());
		assertEquals(user.getSmallAvatar(), savedUser.getSmallAvatar());
		assertEquals(user.getMediumAvatar(), savedUser.getMediumAvatar());
		assertEquals(user.getLargeAvatar(), savedUser.getLargeAvatar());
		assertEquals(user.getLoginIp(), savedUser.getLoginIp());
		assertEquals(user.getLoginSessionId(), savedUser.getLoginSessionId());
		assertEquals(user.getCreatedIp(), savedUser.getCreatedIp());		
		
		
	}
	
	//@Test
//	@Test(expected = Exception.class)
	public void testGetByUsername() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = "admin123";
		User user=new User();
		user.setUsername("admin");
		user.setPassword(password);
		user.setMobile("15833831123");
		user.setTitle("张三");
		user.setType("default");
		user.setSmallAvatar("smallAvator");
		user.setMediumAvatar("mediumAvatar");
		user.setLargeAvatar("largeAvatar");
		user.setRoles("|ROLE_USER|");
		user.setLoginIp("127.0.0.1");
		user.setLoginSessionId("sdfjsdofow");
		user.setCreatedIp("127.0.0.1");
		userService.add(user);
		
		User savedUser = userService.getByUsername(user.getUsername());
		assertNotNull(savedUser);
		assertEquals(user.getUsername(), savedUser.getUsername());
		assertTrue(encoder.matches(password,savedUser.getPassword()));
		assertEquals(user.getMobile(), savedUser.getMobile());
		assertEquals(user.getTitle(), savedUser.getTitle());
		assertEquals(user.getType(), savedUser.getType());
		assertEquals(user.getSmallAvatar(), savedUser.getSmallAvatar());
		assertEquals(user.getMediumAvatar(), savedUser.getMediumAvatar());
		assertEquals(user.getLargeAvatar(), savedUser.getLargeAvatar());
		assertEquals(user.getLoginIp(), savedUser.getLoginIp());
		assertEquals(user.getLoginSessionId(), savedUser.getLoginSessionId());
		assertEquals(user.getCreatedIp(), savedUser.getCreatedIp());	
		
	}
}
