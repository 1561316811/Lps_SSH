package com.lps.dao.basic;

import java.util.List;

import com.lps.model.User;

public interface BasicDAO<T> {
	
	public void save(T t);
	/**
	 * 根据对象的Id删除
	 * @param admin
	 */
	public void delete(T t);
	
	public T findById(int id);

	/**
	 * 根据对象的id判断是否存在
	 * @param admin
	 * @return
	 */
	public boolean isExists(T t);
	
	public List<T> findByProperty(String propertyName, Object value) ;
	
	public  List<T> findAll();
	
	public long findAllCount();
	
	/**
	 * 根据开始的下标begin，以及该从该下标开始的limit个数
	 * @param begin 开始值的下标
	 * @param limit 从该下标开始的limit个数
	 * @return 返回该范围内的list
	 */
	List<T> findListByLimit(long begin, long limit);

}
