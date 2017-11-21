package com.lps.service;

import java.util.Date;
import java.util.List;

import com.lps.model.Admin;
import com.lps.service.basic.BasicService;
/**
 * 若没有直接说明，则所有的查询都是按照id来判断其结果
 * @author 0001
 *
 */
public interface AdminService extends BasicService<Admin>{
	
	public Admin getByUserName(String name);
	
	public Date getRegisterTime(Admin admin);
	
	public String getAvatar(Admin admin);
	
}
