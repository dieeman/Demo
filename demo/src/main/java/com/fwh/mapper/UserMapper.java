package com.fwh.mapper;

import java.util.HashMap;
import java.util.List;

import com.fwh.domain.User;

public interface UserMapper {
	public void delUser();
	public void addUser();
	public List<User> getUser();
	public String getBoggestUserId();
	public List<User> getUserByMap(HashMap<String, String> hashmap);
}
