package com.eqinson.hibernate.service;

import com.eqinson.hibernate.beans.User;
import com.eqinson.hibernate.dao.UserDAO;
import com.eqinson.hibernate.dao.UserDAOImpl;

public class UserServiceImpl implements UserService {

	UserDAO userDAO;

	public boolean login(String username, String password) {
		User record = userDAO.select(username);
		if (record == null) {
			return false;
		} else {
			String pwd = record.getPassword();
			if (pwd != null && pwd.equals(password)) {
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean isExist(String username) {
		User record = userDAO.select(username);
		if (record == null) {
			return false;
		} else {
			return true;
		}
	}

	public Integer register(User record) {
		User user = userDAO.select(record.getUsername());
		if (user != null) {
			return null;
		} else {
			return userDAO.insert(record);
		}
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public static void main(String args[]) {
		UserServiceImpl service = new UserServiceImpl();
		service.setUserDAO(new UserDAOImpl());
		boolean login = service.isExist("admin");
		System.out.print(login);
	}

}
