package com.lps.dao;

import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.model.Admin;

/**
 * 若没有直接声明，基本查询都是根据id来查询
 * @author 0001
 *
 */
public interface AdminDAO extends BasicDAO<Admin>{
	
	public Admin getByUserName(String name);
	/**
	 * 根据对象的id判断是否存在
	 * @param admin
	 * @return
	 */
	
}
