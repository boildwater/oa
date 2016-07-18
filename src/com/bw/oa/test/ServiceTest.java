package com.bw.oa.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bw.oa.domain.User;
import com.bw.oa.service.AuthCheckService;
import com.bw.oa.utils.BwUtil;
import com.bw.oa.service.impl.*;

public class ServiceTest {
	private static ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
	private Logger LOGGER = Logger.getLogger(getClass());
	@Test
	public void testUserLoginCheck(){
		User userCheck=new User();
		userCheck.setUserName("admin");
		userCheck.setUserPwd(BwUtil.getMD5Str("pass", "UTF-8"));
		LOGGER.info(userCheck);
		((AuthCheckService)ac.getBean("authCheckServiceImpl")).checkUserPwd(userCheck);
	}
	@Test
	public void testUserQuery(){
		((TestService)ac.getBean("testService")).userQuery();
		
	}
}
