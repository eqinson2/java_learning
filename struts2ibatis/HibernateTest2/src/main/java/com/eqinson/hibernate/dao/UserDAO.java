package com.eqinson.hibernate.dao;

import com.eqinson.hibernate.beans.User;

public interface UserDAO {
	// 按用户名查询
	public User select(String username);
	// 插入用户
	public Integer insert(User record);
}
