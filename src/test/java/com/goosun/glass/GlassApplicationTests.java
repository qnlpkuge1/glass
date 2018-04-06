package com.goosun.glass;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.goosun.glass.dao.UserDao;
import com.goosun.glass.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class GlassApplicationTests {
	
	@Autowired
	private UserDao userDao;

	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void testUserAdd() {
		User user =new User();
		user.setName("zhang san");
		
		userDao.addUserInfo(user);
		
	}
}
