package com.bw.oa.base;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {

	/**
	 * 保存实体
	 * @param entity 保存的实体对象
	 */
	void save(T entity);

	/**
	 * 删除实体
	 * @param id 主键，根据该主键删除实体
	 */
	void delete(Long id);

	/**
	 * 更新实体
	 * 
	 * @param entity 更新的实体
	 */
	void update(T entity);
	
	
	/**
	 * 存在的时候更新，不存在的时候添加
	 * 
	 * @param entity 实体对象
	 */
	void savaOrUpdate(T entity);

	/**
	 * 查询实体
	 * 
	 * @param id 查询的主键
	 * @return  实体对象
	 */
	T getById(Long id);

	/**
	 * 查询实体
	 * 
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);

	/**
	 * 查询所有
	 * 
	 * @return 所有满足条件的实体对象 list
	 */
	List<T> findAll();
	
	/**
	 * 通过hql查询，返回list列表
	 * @param hql 查询的语句 从where开始  eg: where userName="张三"
	 * @return 满足条件的实体对象列表
	 */
	List<T> getByHql(String hql);
	
	/**
	 * 通过hql查询，返回list列表
	 * @param hql 查询语句 从where开始 eg：where userName=:name 
	 * @param params map类型的参数
	 * @return
	 */
	List<T> getByHql(String hql,Map<String,Object> params);
	
	/**
	 * 分页查询
	 * @param hql 查询的语句 从where开始  eg: where userName="张三"
	 * @param page  页数
	 * @param pageSize  每页大小
	 * @return
	 */
	List<T> getbyHql(String hql,int page,int pageSize);
	
	/**
	 * 分页带参数查询
	 * @param hql 查询的语句 从where开始  eg: where userName=:name
	 * @param params map类型的参数
	 * @param page 页数
	 * @param pageSize  每页大小
	 * @return
	 */
	List<T> getByHql(String hql,Map<String,Object> params,int page,int pageSize);
	
	/**
	 * 通过hql查询，返回一个实体
	 * @param hql  查询的语句 从where开始  eg: where userName="张三"
	 * @return  满足条件的单个对象
	 */
	T getUniqueOneByHql(String hql);
	
	/**
	 * 通过hql查询，返回一个实体
	 * @param hql 查询的语句 从where开始  eg: where userName=:name
	 * @param params
	 * @return
	 */
	T getUniqueOneByHql(String hql,Map<String,Object> params);
	
	
	
	/**
	 * 通过hql得到满足条件的记录数
	 * @param hql 查询的语句 从where开始  eg: where userName="张三"
	 * @return  满足条件的记录数  long型
	 */
	long getSumCountByHql(String hql);
	
	/**
	 * 通过hql得到满足条件的记录数
	 * @param hql 查询的语句 从where开始  eg: where userName="张三"
	 * @param params map类型查询参数
	 * @return  满足条件的记录数  long型
	 */
	long getSumCountByHql(String hql,Map<String,Object> params);
}
