package com.lps.dao.impl;
// default package

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lps.dao.PayPathDAO;
import com.lps.model.Admin;
import com.lps.model.PayPath;
import com.lps.util.PageHibernateCallback;

public class PayPathDAOImpl  implements PayPathDAO{
	public static final String PAY_PATH = "payPath";
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(PayPath transientInstance) {
		hibernateTemplate.save(transientInstance);
	}

	@Override
	public void delete(PayPath persistentInstance) {
		hibernateTemplate.delete(persistentInstance);
	}

	@Override
	public PayPath findById(int id) {
		return hibernateTemplate.get(PayPath.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PayPath> findByProperty(String propertyName, Object value) {
		String queryString = "from PayPath as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, value);
		return (List<PayPath>) queryObject.list();
	}

	@Override
	public List<PayPath> findByPayPath(Object payPath) {
		return findByProperty(PAY_PATH, payPath);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PayPath> findAll() {
		return (List<PayPath>)hibernateTemplate.find("from PayPath");
	}

	@Override
	public long findAllCount() {
		String hql="select count(*) from PayPath";
        List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
        return (long)list.get(0);
	}

	@Override
	public boolean isExists(PayPath t) {
		return findById(t.getId()) == null ? false : true;
	}

	@Override
	public List<PayPath> findListByLimit(long begin, long limit) {
		String hql="from PayPath";
        List<PayPath> list=(List<PayPath>) this.getHibernateTemplate().execute((HibernateCallback<Admin>) new PageHibernateCallback(hql, new Object[]{}, begin, limit));
        if(list!=null&&list.size()>0){
            
            return list;
        }
        return null;
	}
}