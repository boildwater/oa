/**
 * 
 */
package com.bw.oa.service.task.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.druid.pool.DruidDataSource;
import com.bw.oa.service.task.TaskResourceMonitorService;

import freemarker.template.SimpleDate;

/**
 * @author BoiledWater
 *
 */
@Service
public class TaskResourceMonitorServiceImpl implements TaskResourceMonitorService {

	@Resource
	/*private ComboPooledDataSource dataSource;*/
	private DruidDataSource dataSource;
	private Logger LOGGER=Logger.getLogger(getClass());
	/* (non-Javadoc)
	 * @see com.bw.oa.service.ResourceMonitor#monitorConnectionPool()
	 */
	@Override
	public void monitorConnectionPool() {
		// TODO Auto-generated method stub
		try{
		 LOGGER.info("--------数据连接池信息------------");
		 LOGGER.info("数据库驱动："+dataSource.getDriverClassName());
		 LOGGER.info("数据连接池创建时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(dataSource.getCreatedTime()).toString());
		 LOGGER.info("连接池初始化连接数："+dataSource.getInitialSize());
		 LOGGER.info("连接池保留最大连接数："+dataSource.getMaxActive());
		 LOGGER.info("连接池保留最小连接数："+dataSource.getMinIdle());
		 LOGGER.info("连接池正在使用的连接数："+dataSource.getActiveCount());		
		 LOGGER.info("连接池连接总数："+dataSource.getConnectCount());
		 LOGGER.info("--------------------------------------");
		}catch(Exception e){
			LOGGER.error("连接池资源监控出错"+e.getMessage());
		}

	}

}
