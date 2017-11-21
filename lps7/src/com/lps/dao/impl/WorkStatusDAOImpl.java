package com.lps.dao.impl;
// default package

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lps.dao.WorkStatusDAO;
import com.lps.model.Admin;
import com.lps.model.User;
import com.lps.model.WorkStatus;
import com.lps.util.PageHibernateCallback;

public class WorkStatusDAOImpl implements WorkStatusDAO {
	// property constants
	public static final String WORK_STATUS = "workStatus";

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(WorkStatus transientInstance) {
		hibernateTemplate.save(transientInstance);
	}

	@Override
	public void delete(WorkStatus persistentInstance) {
		hibernateTemplate.delete(persistentInstance);
	}

	@Override
	public WorkStatus findById(int id) {
		return hibernateTemplate.get(WorkStatus.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WorkStatus> findByProperty(String propertyName, Object value) {
		String queryString = "from WorkStatus as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, value);
		return (List<WorkStatus>) queryObject.list();
	}

	@Override
	public List<WorkStatus> findByWorkStatus(Object workStatus) {
		return findByProperty(WORK_STATUS, workStatus);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WorkStatus> findAll() {
		return (List<WorkStatus>)hibernateTemplate.find("from WorkStatus");
	}

	@Override
	public long findAllCount() {
		String hql="select count(*) from WorkStatus";
        List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
        return (long)list.get(0);
	}

	@Override
	public boolean isExists(WorkStatus t) {
		return findById(t.getId()) == null ? false : true;
	}

	@Override
	public List<WorkStatus> findListByLimit(long begin, long limit) {
		String hql="from WorkStatus";
        @SuppressWarnings("unchecked")
		List<WorkStatus> list=(List<WorkStatus>) this.getHibernateTemplate().execute((HibernateCallback<Admin>) new PageHibernateCallback(hql, new Object[]{}, begin, limit));
        if(list!=null&&list.size()>0){
            return list;
        }
        return null;
	}

}