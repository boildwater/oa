/**
 * 
 */
package com.bw.oa.service;

import com.bw.oa.domain.User;

/**
 * @author BoiledWater
 *
 */
public interface AuthCheckService {
	public boolean checkUserPwd(User userCheck);

}
