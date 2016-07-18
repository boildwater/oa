package com.bw.oa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bw.oa.dao.UserDao;
import com.bw.oa.dao.impl.DepartmentDaoImpl;
import com.bw.oa.dao.impl.MenuDaoImpl;
import com.bw.oa.dao.impl.UserDaoImpl;
import com.bw.oa.domain.Department;
import com.bw.oa.domain.User;
import com.bw.oa.utils.BwUtil;
import com.bw.oa.utils.JsonUtil;

@Service("testService")
public class TestService {
	private static Logger logger=Logger.getLogger(TestService.class);
	@Resource
	private UserDao userDaoImpl;
	@Resource
	private DepartmentDaoImpl departmentDaoImpl;
	@Resource
	private MenuDaoImpl menuImpl;
	@Transactional
	public void saveTwoUsers(){
		User u1=new User();
		Department department=departmentDaoImpl.getUniqueOneByHql("where name='开发部'");
		
		u1.setId((long) (Math.random()*10));
		u1.setUserName("admin"+(int)(Math.random()*1000));
		u1.setUserPwd(BwUtil.getMD5Str("pass","UTF-8"));
		u1.setDepartment(department);
		User u2=new User();
		u2.setId((long) (Math.random()*10));
		u2.setUserName("李四");
		u2.setUserPwd("222");
		logger.info("----"+u1);
		logger.info("----"+u2);
		userDaoImpl.save(u1);
		logger.info("----"+userDaoImpl.getSumCountByHql(""));
	}
	@Transactional(readOnly=true)
	public void getUser(){
		logger.info("-----从数据库中查找user 检查是否将department一起查出来了");
		User u=userDaoImpl.getById(7L);
		logger.info(u);
	}
	@Transactional
	public void addMeun(){
		logger.info("----测试菜单");
		//Menu menu=menuImpl.getOneByHql("where menuName='开始'");
		Department department=departmentDaoImpl.getUniqueOneByHql("where name='开发部'");
		Map map=new HashMap();
		map.put("department", department);
		logger.info("-------测试结束");
	}
	@Transactional(readOnly=true)
	public void userQuery() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", "%admin%");
		List<User> userList = userDaoImpl.getByHql("where userName like:name", params);
		for (User u : userList) {
			logger.info(u);
		}
	}

}
