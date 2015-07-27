package com.demo.hibernate.service;

import com.demo.hibernate.beans.User;

public interface UserService {
	public boolean login(String username, String password);

	public boolean isExist(String username);

	public Integer register(User record);
}
