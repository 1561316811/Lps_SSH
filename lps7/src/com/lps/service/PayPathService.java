package com.lps.service;
import java.util.List;

import com.lps.model.PayPath;
import com.lps.service.basic.BasicService;

public interface PayPathService extends BasicService<PayPath>{


	List<PayPath> findByPayPath(Object workStatus);

}