package com.goosun.glass.service;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.goosun.glass.component.EachTestInitialization;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class BaseServiceTest {

	//@Autowired
	//private EachTestInitialization eachTestInitialization;
	
	@Before
	public void eachInit() throws Exception {
		//eachTestInitialization.init();
	}
}
