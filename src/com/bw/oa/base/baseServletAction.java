/**
 * 
 */
package com.bw.oa.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author BoiledWater
 * @since 2016-07-08
 * @descript 如果action中需要使用到reques、response、session 则直接继承
 */

public abstract class baseServletAction extends ActionSupport implements SessionAware,
		ServletResponseAware, ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8782110848121114427L;
	public HttpServletResponse response;
	public HttpServletRequest request;
	public Map<String, Object> session;
	private static final Logger LOGGER = Logger.getLogger(baseServletAction.class);

	/**
	 * 得到response并保存,子类直接使用
	 */
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;

	}
	/**
	 * 向前台返回json
	 * @param 返回前台的对象
	 */
	public void writeJson(Object obj){
		PrintWriter out=null;
		try {
			String json = JSON.toJSONStringWithDateFormat(obj, "yyyy-MM-dd HH:mm:ss");
			response.setContentType("text/html;charset=utf-8");
			out=response.getWriter();
			out.write(json);
		} catch (IOException e) {
			LOGGER.error("向前台返回数据失败："+e.getMessage());
			e.printStackTrace();
		}finally{
			if(null!=out){
				out.flush();
				out.close();
			}
		}
	}

}
