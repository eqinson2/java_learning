package com.demo.hibernate.service;

import com.demo.hibernate.beans.User;
import com.demo.hibernate.dao.UserDAO;

public class UserService {

	public boolean valid(String username, String password) {
		UserDAO test = new UserDAO();
		User user = test.getUser("admin");
		if (user.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		UserService service = new UserService();
		boolean login = service.valid("admin", "admin");
		System.out.println("result:" + login);
	}
}
