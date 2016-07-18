/**
 * 
 */
package com.bw.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bw.oa.dao.UserDao;
import com.bw.oa.domain.User;
import com.bw.oa.service.AuthCheckService;



/**
 * @author BoiledWater
 *
 */
@Service("authCheckServiceImpl")
@Transactional
public class AuthCheckServiceImpl implements AuthCheckService {
	@Resource
	private UserDao userDaoImpl; 
	@Override
	public boolean checkUserPwd(User userCheck) {
		// TODO Auto-generated method stub
		boolean AuthRightFlag=false;
		User userDb= userDaoImpl.getUniqueOneByHql("where userName='"+userCheck.getUserName()+"'");
		if(userDb!=null && userDb.getUserPwd().equals(userCheck.getUserPwd())){
			AuthRightFlag=true;
		}
		return AuthRightFlag;
	}



	

}
