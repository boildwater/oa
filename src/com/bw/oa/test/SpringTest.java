package com.bw.oa.test;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;
import com.bw.oa.service.impl.TaskDemoServiceImpl;
import com.bw.oa.service.impl.TestService;

public class SpringTest {
	private final static Logger LOGGER=Logger.getLogger(SpringTest.class);
	private static ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
	//测试sessionFactory是否正确
	@Test
	public void testSessionFactory() throws Exception {
		SessionFactory sf=(SessionFactory) ac.getBean("sessionFactory");
		System.out.println(sf);
	}
	@Test
	public void testTransaction()  throws Exception{
		TestService ts=(TestService) ac.getBean("testService");
		ts.saveTwoUsers();
		ts.getUser();
		ts.addMeun();
	}
	@Test
	public void testC3P0DataSource() throws SQLException{
		/* ComboPooledDataSource ds=(ComboPooledDataSource) ac.getBean("dataSource");*/
		DruidDataSource ds=(DruidDataSource) ac.getBean("dataSource");
	/*	 LOGGER.info("--------数据连接池信息------------");
		 LOGGER.info("数据库驱动："+ds.getDriverClass());
		 LOGGER.info("连接池保留最大连接数："+ds.getMaxPoolSize());
		 LOGGER.info("连接池保留最小连接数："+ds.getMinPoolSize());
		 LOGGER.info("连接池正在使用的连接数："+ds.getNumBusyConnections());
		 LOGGER.info("连接池空闲的连接数："+ds.getNumIdleConnections());
		 LOGGER.info("连接池总连接数："+ds.getNumConnections());
		 LOGGER.info("连接池最大允许空闲时间："+ds.getMaxIdleTime()+"秒");
		 LOGGER.info("连接池最大连接时间："+ds.getMaxConnectionAge());
		 LOGGER.info("--------------------------------------");
		 */
	}
	@Test 
	public void testTask(){
		TaskDemoServiceImpl task=(TaskDemoServiceImpl) ac.getBean("taskDemoServiceImpl");
	}

}
