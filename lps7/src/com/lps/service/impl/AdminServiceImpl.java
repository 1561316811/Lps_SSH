package com.lps.service.impl;

import java.util.Date;
import java.util.List;

import com.lps.dao.AdminDAO;
import com.lps.model.Admin;
import com.lps.model.PayPath;
import com.lps.model.User;
import com.lps.service.AdminService;
import com.lps.util.PageBean;

//@Component("adminServiceImpl")
//@Aspect
public class AdminServiceImpl implements AdminService {
	
	private AdminDAO adminDao ;
	
	private PageBean<Admin> pageBean;

	public PageBean<Admin> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<Admin> pageBean) {
		this.pageBean = pageBean;
	}
	
	public AdminDAO getAdminDao() {
		return adminDao;
	}

//	@Resource(name="adminDAOImpl")
	public void setAdminDao(AdminDAO adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public void save(Admin admin) {
		adminDao.save(admin);
	}

	@Override
	public void delete(Admin admin) {
		adminDao.delete(admin);
	}

	@Override
	public Admin getByUserName(String name) {
		return adminDao.getByUserName(name);
	}

	@Override
	public Admin findById(int id) {
		return adminDao.findById(id);
	}
	
	@Override
	public boolean isExists(Admin admin) {
		return adminDao.isExists(admin);
	}

	@Override
	public Date getRegisterTime(Admin admin) {
		return findById(admin.getId()).getRegisterTime();
	}

	@Override
	public String getAvatar(Admin admin) {
		return findById(admin.getId()).getAvatar();
	}
	@Override
	public List<Admin> findByProperty(String propertyName, Object value){
		return adminDao.findByProperty(propertyName, value);
	}

	@Override
	public List<Admin> findAll() {
		return adminDao.findAll();
	}

	@Override
	public long findAllCount() {
		return adminDao.findAllCount();
	}

	@Override
	public PageBean<Admin> findByPage(int page) {
		pageBean.setPage(page);
        
        long totalCount= findAllCount();
        
        pageBean.setAllCount(totalCount);
        
        long limit  = pageBean.getLimit();
        
        long totalpage=(long)Math.ceil(totalCount/limit);
        
        pageBean.setAllPage(totalpage);
        //每页显示的数据集合
        long begin=(page-1) * limit;
        
        List<Admin> list = adminDao.findListByLimit(begin, limit);
        
        pageBean.setList(list);
        
        return pageBean;
	}


}
