package com.bw.dao;

import java.util.List;

import com.bw.entity.Order;
import com.bw.entity.QueryVo;
import com.bw.entity.User;

public interface UserDao {
	User getUserById(int id);
	
	int insertUser(User user);
	
	void deleteUser(int id);
	
	List<User> getUserByName(String str);
	
	void updateUser(User user);
	
	List<User> getUserByQueryVo(QueryVo qv);
	
	Integer getUserCount();
	
	List<User> getUserByIdFor(QueryVo qv);
	
	User getUserOrder(Integer id);

	List<User> getUserOrderAll();
}
