/**
 * 
 */
package com.bw.oa.view.action;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.bw.oa.base.baseServletAction;
import com.bw.oa.domain.User;
import com.bw.oa.service.AuthCheckService;
import com.bw.oa.utils.BwUtil;
import com.opensymphony.xwork2.Action;

/**
 * @author BoiledWater
 * 
 */
@SuppressWarnings("serial")
// 加上注解，交给spring进行管理.
@Controller
@Scope("prototype")
public class AuthCheckAction extends baseServletAction {
	private Logger				LOGGER	= Logger.getLogger(getClass());
	@Resource
	private AuthCheckService	authCheckServiceImpl;
	
	public String checkLoginAuth() {
		LOGGER.info("-----checkLoginAuth  用户登录权限检查");
		String userName = request.getParameter("user_name");
		String userPwd = request.getParameter("user_pwd");
		String userVerify = request.getParameter("user_validateCode");
		// 正确的验证码
		String userLoginRightVerifyCode = (String) session.get("validatecode");
		LOGGER.info("-----checkLoginAuth  用户登录权限检查 正确的验证码:" + userLoginRightVerifyCode);
		StringBuffer checkResult = new StringBuffer(""); // 收集错误
		if (BwUtil.isEmptyString(userName)) {
			checkResult.append("用户名不能为空！");
		}
		if (BwUtil.isEmptyString(userPwd)) {
			checkResult.append("密码不能为空！");
		}
		if (BwUtil.isEmptyString(userVerify)) {
			checkResult.append("验证码不能为空！");
		}
		if (BwUtil.isEmptyString(userLoginRightVerifyCode)) {
			checkResult.append("服务器超时，请刷新后重试!");
		}
		if (checkResult.length() == 0) { // 基础检查全部通过
			if (!userVerify.equalsIgnoreCase(userLoginRightVerifyCode)) {
				LOGGER.info(userVerify + "!=" + userLoginRightVerifyCode.toLowerCase());
				checkResult.append("验证码错误！");
			} else {
				User user = new User();
				user.setUserName(userName);
				user.setUserPwd(userPwd);
				if (authCheckServiceImpl.checkUserPwd(user)) {
					request.getSession().setAttribute("loginUserName", user.getUserName());
					checkResult.append("登录成功");
				} else {
					checkResult.append("用户登录失败，错误的用户名或密码！");
				}
			}
		}
		LOGGER.info(checkResult);
		Map<String, Object> mapRes = new HashMap<String, Object>();
		mapRes.put("msg", checkResult);
		super.writeJson(mapRes);  /*向前台返回json数据*/
		return Action.SUCCESS;
		
	}
}
