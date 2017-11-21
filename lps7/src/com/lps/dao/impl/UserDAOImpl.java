package com.lps.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lps.dao.UserDAO;
import com.lps.model.Admin;
import com.lps.model.PayPath;
import com.lps.model.User;
import com.lps.util.PageHibernateCallback;

public class UserDAOImpl implements UserDAO {

	public static final String USER_NAME = "userName";
	public static final String PASSWORD = "password";
	public static final String WORK_ID = "workId";
	public static final String TELEPHONE_PHONE = "telephonePhone";
	public static final String EMAIL = "email";
	public static final String ADDRESS = "address";
	public static final String AVATAR = "avatar";
	public static final String QUESTION = "question";
	public static final String ANSWER = "answer";

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(User transientInstance) {
		hibernateTemplate.save(transientInstance);
	}

	@Override
	public void delete(User persistentInstance) {
		hibernateTemplate.delete(persistentInstance);
	}

	@Override
	public User findById(int id) {
		return hibernateTemplate.get(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByProperty(String propertyName, Object value) {
		String queryString = "from User as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, value);
		
		return (List<User>) queryObject.list();
	}

	public List<User> findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	@Override
	public List<User> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	@Override
	public List<User> findByWorkId(Object workId) {
		return findByProperty(WORK_ID, workId);
	}

	@Override
	public List<User> findByTelephonePhone(Object telephonePhone) {
		return findByProperty(TELEPHONE_PHONE, telephonePhone);
	}
	
	@Override
	public List<User> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	@Override
	public List<User> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	@Override
	public List<User> findByAvatar(Object avatar) {
		return findByProperty(AVATAR, avatar);
	}

	@Override
	public List<User> findByQuestion(Object question) {
		return findByProperty(QUESTION, question);
	}

	@Override
	public List<User> findByAnswer(Object answer) {
		return findByProperty(ANSWER, answer);
	}

	

	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		return (List<User>)hibernateTemplate.find("from User");
	}
	
	public void update(){
		hibernateTemplate.update();
	}

	@Override
	public long findAllCount() {
		String hql="select count(*) from User";
        List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
        return (long)list.get(0);
	}

	@Override
	public boolean isExists(User user) {
		if(findById(user.getId()) != null)
			return true;;
		return false;
	}

	@Override
	public List<User> findListByLimit(long begin, long limit) {
		String hql="from User";
        List<User> list=(List<User>) this.getHibernateTemplate().execute((HibernateCallback<Admin>) new PageHibernateCallback(hql, new Object[]{}, begin, limit));
        if(list!=null&&list.size()>0){
            
            return list;
        }
        return null;
	}

}
