/**
 * 
 */
package com.bw.oa.dao.impl;

import org.springframework.stereotype.Repository;

import com.bw.oa.base.BaseDao;
import com.bw.oa.base.BaseDaoImpl;
import com.bw.oa.dao.UserDao;
import com.bw.oa.domain.User;

/**
 * @author BoiledWater
 *
 */
@Repository(value="userDaoImpl")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	
}
