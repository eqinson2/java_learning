package com.demo.hibernate.dao;

import com.demo.hibernate.beans.User;

public interface UserDAO {
	public User select(String username);

	public Integer insert(User record);
}
