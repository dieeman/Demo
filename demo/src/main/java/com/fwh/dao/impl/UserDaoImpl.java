package com.fwh.dao.impl;

import java.util.HashMap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fwh.dao.UserDao;
import com.fwh.domain.User;
import com.fwh.mapper.UserMapper;
@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	public UserMapper useMapper;
	@Override
	public void delUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBoggestUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserByMap(HashMap<String, String> hashmap) {
		// TODO Auto-generated method stub
		List<User> userlist = useMapper.getUserByMap(hashmap);
		return userlist;
	}

}
