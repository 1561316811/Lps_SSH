package com.lps.dao;
import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.model.PayPath;
import com.lps.model.WorkStatus;

public interface PayPathDAO extends BasicDAO<PayPath>{

	List<PayPath> findByPayPath(Object workStatus);

}