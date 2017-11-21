package com.lps.service.impl;

import java.util.List;

import com.lps.dao.PayPathDAO;
import com.lps.model.PayPath;
import com.lps.model.User;
import com.lps.service.PayPathService;
import com.lps.util.PageBean;

//@Component("adminServiceImpl")
//@Aspect
public class PayPathServiceImpl implements PayPathService {
	
	private PayPathDAO payPathDao ;
	
	private PageBean<PayPath> pageBean;

	public PageBean<PayPath> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<PayPath> pageBean) {
		this.pageBean = pageBean;
	}
	
	public PayPathDAO getPayPathDao() {
		return payPathDao;
	}

	public void setPayPathDao(PayPathDAO payPathDao) {
		this.payPathDao = payPathDao;
	}

	@Override
	public void delete(PayPath payPath) {
		payPathDao.delete( payPath);
	}

	@Override
	public List<PayPath> findAll() {
		return payPathDao.findAll();
	}

	@Override
	public long findAllCount() {
		return payPathDao.findAllCount();
	}

	@Override
	public PayPath findById(int id) {
		return payPathDao.findById(id);
	}

	@Override
	public List<PayPath> findByProperty(String propertyName, Object value) {
		return payPathDao.findByProperty(propertyName, value);
	}

	@Override
	public List<PayPath> findByPayPath(Object payPath) {
		return payPathDao.findByPayPath(payPath);
	}

	@Override
	public void save(PayPath payPath) {
		payPathDao.save(payPath);
	}

	@Override
	public boolean isExists(PayPath user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PageBean<PayPath> findByPage(int page) {
		pageBean.setPage(page);
        
        long totalCount= findAllCount();
        
        pageBean.setAllCount(totalCount);
        
        long limit  = pageBean.getLimit();
        
        long totalpage=(long)Math.ceil(totalCount/limit);
        
        pageBean.setAllPage(totalpage);
        //每页显示的数据集合
        long begin=(page-1) * limit;
        
        List<PayPath> list = payPathDao.findListByLimit(begin, limit);
        
        pageBean.setList(list);
        
        return pageBean;
	}



}
