package com.bw.oa.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@SuppressWarnings("unchecked")
public  class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource
	private SessionFactory sessionFactory;
	protected Class<T> clazz; 

	public BaseDaoImpl() {
		// 通过反射得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}

	@Override
	public void save(T entity) {
		getSession().save(entity);
	}

	public void update(T entity) {
		getSession().update(entity);
	}

	public void delete(Long id) {
		Object obj = getSession().get(clazz, id);
		getSession().delete(obj);
	}
	
	public void savaOrUpdate(T entity){
		getSession().saveOrUpdate(entity);
	}

	public T getById(Long id) {
		return (T) getSession().get(clazz, id);
	}


	public List<T> getByIds(Long[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		}

		return getSession().createQuery(//
				"FROM " + clazz.getSimpleName() + " WHERE id IN(:ids)")//
				.setParameterList("ids", ids)//
				.list();
	}

	public List<T> findAll() {
		return  this.getQuery("").list();
	}
	
	/*
	 * 通过hql查询，返回list列表
	 * @param hql
	 * @return
	 */
	public List<T> getByHql(String hql) {
		return this.getQuery(hql).list();
	}

	/*
	 * 分页查询
	 * @param hql
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<T> getbyHql(String hql, int page, int pageSize) {
		return this.getQuery(hql).setFirstResult((page - 1) * pageSize) //
				.setMaxResults(pageSize) //
				.list();
	}
	/*
	 * 通过hql查询，返回一个实体
	 * @param hql
	 * @return
	 */
	public T getUniqueOneByHql(String hql){
		return (T) this.getQuery(hql).uniqueResult();
	}
	/*
	 * 通过hql得到满足条件的记录数
	 * @param hql
	 * @return
	 */
	public long getSumCountByHql(String hql){
		//return getSession().createQuery("FROM " + clazz.getSimpleName()+" "+hql).list().size();
		return ((Number) getSession().createQuery(  //
				"select count(*) FROM " + clazz.getSimpleName() + " " + hql) // 
				.uniqueResult()).longValue();
	}

	/*
	 * 获取当前可用的Session
	 * 
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<T> getByHql(String hql, Map<String, Object> params) {
		if(params==null || params.isEmpty()){
			return this.getByHql(hql);
		}else{
			
			return getQuery(hql, params).list();
		}
	}

	@Override
	public List<T> getByHql(String hql, Map<String, Object> params, int page, int pageSize) {
		if(params==null || params.isEmpty()){
			return this.getbyHql(hql, page, pageSize);
		}else{
			return getQuery(hql, params).setFirstResult((page - 1) * pageSize) //
					.setMaxResults(pageSize) //
					.list();
		}
	}

	@Override
	public T getUniqueOneByHql(String hql, Map<String, Object> params) {
		if(params==null || params.isEmpty()){
			return this.getUniqueOneByHql(hql);
		}else{
			
			return (T) getQuery(hql, params).uniqueResult();
		}
	}

	@Override
	public long getSumCountByHql(String hql, Map<String, Object> params) {
		if(params==null || params.isEmpty()){
			return this.getSumCountByHql(hql);
		}else
		{
			Query q=getSession().createQuery("select count(*) FROM " + clazz.getSimpleName()+" "+hql);
			for(String key:params.keySet()){
				q.setParameter(key, params.get(key));
			}
			return (Long) q.uniqueResult();
		}
	}
	/**
	 * 得到公共用的Query,带参数
	 * @param hql
	 * @param params
	 * @return
	 */
	private Query getQuery(String hql,Map<String,Object> params){
		Query q=getSession().createQuery("FROM " + clazz.getSimpleName()+" "+hql);
		for(String key:params.keySet()){
			q.setParameter(key, params.get(key));
		}
		return q;
	}
	/**
	 * 得到公共用的Query，不带参数
	 * @param hql
	 * @return
	 */
	private Query getQuery(String hql){
		return getSession().createQuery("FROM " + clazz.getSimpleName()+" "+hql);
	}

}
