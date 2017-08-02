package com.fwh.service;
import java.util.HashMap;
import java.util.List;
import com.fwh.domain.User;
public interface UserService {
	public User getUserByid(String id);
	public List<User> getUserByMap(HashMap hashmap);
	public List<User> getUser();
	public void updateUser(User user);
	public void deleteUserByid(String id);
	public void addUser(User user);
	public String getBiggestUserId();

}
