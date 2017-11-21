package com.lps.dao;
import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.model.PayPath;
import com.lps.model.WorkStatus;

public interface WorkStatusDAO extends BasicDAO<WorkStatus>{

	List<WorkStatus> findByWorkStatus(Object workStatus);

}