package com.demo.ibatis.service;

import com.demo.ibatis.beans.User;

public interface UserService {
	public boolean login(String username, String password);

	public boolean isExist(String username);

	public Integer register(User record);
}
