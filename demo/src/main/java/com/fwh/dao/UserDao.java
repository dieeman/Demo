package com.fwh.dao;

import java.util.HashMap;
import java.util.List;

import com.fwh.domain.User;

public interface UserDao {
	public void delUser();
	public void addUser();
	public List<User> getUser();
	public String getBoggestUserId();
	public List<User> getUserByMap(HashMap<String, String> hashmap);
}
