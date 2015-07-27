package com.eqinson.hibernate.service;

import com.eqinson.hibernate.beans.User;

public interface UserService {
	public boolean login(String username, String password);

	public boolean isExist(String username);

	public Integer register(User record);
}
