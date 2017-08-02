package com.fwh.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fwh.dao.UserDao;
import com.fwh.domain.User;
import com.fwh.mapper.UserMapper;
import com.fwh.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	private  Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	public UserDao userDao;		
	public User getUserByid(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<User> getUserByMap(HashMap hashmap) {
		// TODO Auto-generated method stub
		List<User> userlist = userDao.getUserByMap(hashmap);
		return userlist;
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	public void deleteUserByid(String id) {
		// TODO Auto-generated method stub

	}

	public void addUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		logger.info("日志测试1");
		List<User> userlist = userDao.getUser();
		logger.info("日志测试2");
		return userlist;
	}

	@Override
	public String getBiggestUserId() {
		// TODO Auto-generated method stub
		return null;
	}

}
