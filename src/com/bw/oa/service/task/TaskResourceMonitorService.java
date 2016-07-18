/**
 * 
 */
package com.bw.oa.service.task;

/**
 * @author BoiledWater
 * @descript 定时监控系统资源情况
 *
 */
public interface TaskResourceMonitorService {
	/**
	 * 监控数据库连接池的状态
	 */
	public void monitorConnectionPool();
}
