package com.lps.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lps.dao.AdminDAO;
import com.lps.model.Admin;
import com.lps.util.PageHibernateCallback;

public class AdminDAOImpl implements AdminDAO {
	
	public static final String USER_NAME = "userName";
	public static final String PASSWORD = "password";
	public static final String AVATAR = "avatar";
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(Admin admin) {
		hibernateTemplate.save(admin);
	}

	@Override
	public void delete(Admin admin) {
		hibernateTemplate.delete(admin);
	}

	@Override
	public Admin findById(int id) {
		return hibernateTemplate.get(Admin.class, id);
	}

	@Override
	public boolean isExists(Admin admin) {
		if(findById(admin.getId()) != null)
			return true;;
		return false;
	}

	@Override
	public Admin getByUserName(String name) {
		List<?> tempList = hibernateTemplate.find("from Admin a where a.userName = '" + name + "'");
		if(tempList.size() > 0)
			return (Admin)tempList.get(0);
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> findByProperty(String propertyName, Object value) {
	         String queryString = "from Admin as model where model." 
	         						+ propertyName + "= ?";
	         Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
			 queryObject.setParameter(0, value);
System.out.println("findByProperty");
			 return (List<Admin>)queryObject.list();
	 }
	
	
	@Override
	public  List<Admin> findAll(){
		return (List<Admin>)hibernateTemplate.find("from Admin");
	}

	@Override
	public long findAllCount() {
		String hql="select count(*) from Admin";
        List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
        return (long)list.get(0);
	}

	@Override
	public List<Admin> findListByLimit(long begin, long limit) {
		String hql="from Admin";
        List<Admin> list=(List<Admin>) this.getHibernateTemplate().execute((HibernateCallback<Admin>) new PageHibernateCallback(hql, new Object[]{}, begin, limit));
        if(list!=null&&list.size()>0){
            
            return list;
        }
        return null;
	}
	
	
}
