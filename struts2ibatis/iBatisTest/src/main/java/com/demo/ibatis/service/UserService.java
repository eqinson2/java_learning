package com.demo.ibatis.service;

import com.demo.ibatis.beans.User;
import com.demo.ibatis.dao.UserDAO;
import com.demo.ibatis.util.SqlMapClientFactory;

public class UserService {
	public boolean valid(String username, String password) {
		try {
			UserDAO userDAO = new UserDAO();
			userDAO.setSqlMapClient(SqlMapClientFactory.getSqlMapClient());

			User user = userDAO.getUser("admin");
			if (user.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		UserService service = new UserService();
		boolean login = service.valid("admin", "admin");
		System.out.println("result:" + login);
	}
}
