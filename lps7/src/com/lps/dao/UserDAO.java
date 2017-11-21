package com.lps.dao;

import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.model.User;

public interface UserDAO extends BasicDAO<User>{

	List<User> findByPassword(Object password);

	List<User> findByWorkId(Object workId);

	List<User> findByTelephonePhone(Object telephonePhone);

	List<User> findByEmail(Object email);

	List<User> findByAddress(Object address);

	List<User> findByAvatar(Object avatar);

	List<User> findByQuestion(Object question);

	List<User> findByAnswer(Object answer);

	List<User> findListByLimit(long begin, long limit);


}