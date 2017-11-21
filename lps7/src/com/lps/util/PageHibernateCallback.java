package com.lps.util;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;

public class PageHibernateCallback<T> implements HibernateCallback<List<T>>{
    
    private String hql;
    private Object[] params;
    private long startIndex;
    private long pageSize;
    

    public PageHibernateCallback(String hql, Object[] params,
    		long startIndex, long pageSize) {
        super();
        this.hql = hql;
        this.params = params;
        this.startIndex = startIndex;
        this.pageSize = pageSize;
    }



    public List<T> doInHibernate(Session session) throws HibernateException {
        Query query = session.createQuery(hql);
        
        if(params != null){
            for(int i = 0 ; i < params.length ; i ++){
                query.setParameter(i, params[i]);
            }
        }
        
        query.setFirstResult((int)startIndex);
        query.setMaxResults((int)pageSize);
        
        return query.list();
    }

}