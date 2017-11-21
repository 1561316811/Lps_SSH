package com.lps.service;

import java.util.List;

import com.lps.model.User;
import com.lps.service.basic.BasicService;
import com.lps.util.PageBean;

public interface UserService extends BasicService<User>{
	

	List<User> findByPassword(Object password);

	List<User> findByWorkId(Object workId);

	List<User> findByTelephonePhone(Object telephonePhone);

	List<User> findByEmail(Object email);

	List<User> findByAddress(Object address);

	List<User> findByAvatar(Object avatar);

	List<User> findByQuestion(Object question);

	List<User> findByAnswer(Object answer);

}