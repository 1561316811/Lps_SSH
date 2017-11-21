package com.lps.service.impl;

import java.util.List;

import com.lps.dao.UserDAO;
import com.lps.model.Admin;
import com.lps.model.User;
import com.lps.service.UserService;
import com.lps.util.PageBean;

public class UserServiceImpl implements UserService {
	
	private UserDAO userDao ;
	
	private PageBean<User> pageBean;

	public PageBean<User> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<User> pageBean) {
		this.pageBean = pageBean;
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public void save(User user) {
		userDao.save( user);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}


	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}
	
	@Override
	public boolean isExists(User user) {
		return userDao.isExists(user);
	}


	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public long findAllCount() {
		return userDao.findAllCount();
	}

	@Override
	public List<User> findByProperty(String propertyName, Object value) {
		return userDao.findByProperty(propertyName, value);
	}

	@Override
	public List<User> findByPassword(Object password) {
		return userDao.findByPassword(password);
	}

	@Override
	public List<User> findByWorkId(Object workId) {
		return userDao.findByWorkId(workId);
	}

	@Override
	public List<User> findByTelephonePhone(Object telephonePhone) {
		return userDao.findByTelephonePhone(telephonePhone);
	}

	@Override
	public List<User> findByEmail(Object email) {
		return userDao.findByEmail(email);
	}

	@Override
	public List<User> findByAddress(Object address) {
		return userDao.findByAddress(address);
	}

	@Override
	public List<User> findByAvatar(Object avatar) {
		return userDao.findByAvatar(avatar);
	}

	@Override
	public List<User> findByQuestion(Object question) {
		return userDao.findByQuestion(question);
	}

	@Override
	public List<User> findByAnswer(Object answer) {
		return userDao.findByAnswer(answer);
	}
	
	public PageBean<User> findByPage(int page) {
        pageBean.setPage(page);
        
        long totalCount= findAllCount();
        
        pageBean.setAllCount(totalCount);
        
        long limit  = pageBean.getLimit();
        
        long totalpage=(long)Math.ceil(totalCount/limit);
        
        pageBean.setAllPage(totalpage);
        //每页显示的数据集合
        long begin=(page-1) * limit;
        
        List<User> list = userDao.findListByLimit(begin, limit);
        
        pageBean.setList(list);
        
        return pageBean;
    }


}
