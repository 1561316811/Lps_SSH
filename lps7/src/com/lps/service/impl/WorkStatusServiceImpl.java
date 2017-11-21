package com.lps.service.impl;

import java.util.List;

import com.lps.dao.WorkStatusDAO;
import com.lps.model.User;
import com.lps.model.WorkStatus;
import com.lps.service.WorkStatusService;
import com.lps.util.PageBean;

//@Component("adminServiceImpl")
//@Aspect
public class WorkStatusServiceImpl implements WorkStatusService {
	
	private WorkStatusDAO dao;
	
	private PageBean<WorkStatus> pageBean;

	public PageBean<WorkStatus> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<WorkStatus> pageBean) {
		this.pageBean = pageBean;
	}
	
	@Override
	public void delete(WorkStatus workStatus) {
		dao.delete( workStatus);
	}

	@Override
	public List<WorkStatus> findAll() {
		return dao.findAll();
	}

	@Override
	public long findAllCount() {
		return dao.findAllCount();
	}

	@Override
	public WorkStatus findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<WorkStatus> findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}

	@Override
	public List<WorkStatus> findByWorkStatus(Object workStatus) {
		return dao.findByWorkStatus(workStatus);
	}

	public WorkStatusDAO getWorkStatusDao() {
		return dao;
	}

	@Override
	public void save(WorkStatus workStatus) {
		dao.save(workStatus);
	}

	public void setWorkStatusDao(WorkStatusDAO workStatusDao) {
		this.dao = workStatusDao;
	}

	@Override
	public boolean isExists(WorkStatus user) {
		return dao.isExists(user);
	}

	@Override
	public PageBean<WorkStatus> findByPage(int page) {
		pageBean.setPage(page);
        
        long totalCount= findAllCount();
        
        pageBean.setAllCount(totalCount);
        
        long limit  = pageBean.getLimit();
        
        long totalpage=(long)Math.ceil(totalCount/limit);
        
        pageBean.setAllPage(totalpage);
        //每页显示的数据集合
        long begin=(page-1) * limit;
        
        List<WorkStatus> list = dao.findListByLimit(begin, limit);
        
        pageBean.setList(list);
        
        return pageBean;
	}


}
