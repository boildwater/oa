/**
 * 
 */
package com.bw.oa.test;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.bw.oa.domain.User;
import com.bw.oa.utils.JsonUtil;

/**
 * @author BoiledWate
 *
 */
public class ToolsTest {
	private static final Logger LOGGER = Logger.getLogger(ToolsTest.class);
	@Test
	public void testJsonUtil(){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("姓名", "张三");
		
		LOGGER.info(JsonUtil.MapToJSON(map));
	}
	@Test
	public void testFastJson(){
		User u=new User();
		u.setUserName("张三");
	
		LOGGER.info(JSONObject.fromObject(u));
		/*当属性有值得时候，才将属性添加到json**/
		LOGGER.info(JSON.toJSONString(u,true));
		
	}


}
