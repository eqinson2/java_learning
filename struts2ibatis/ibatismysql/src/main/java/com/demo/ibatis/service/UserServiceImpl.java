package com.demo.ibatis.service;

import java.util.List;

import com.demo.ibatis.beans.User;
import com.demo.ibatis.beans.UserExample;
import com.demo.ibatis.beans.UserExample.Criteria;
import com.demo.ibatis.dao.UserDAO;

public class UserServiceImpl implements UserService {

	UserDAO userDAO;

	public boolean login(String username, String password) {
		try {
			UserExample example = new UserExample();
			Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(username);

			List<User> list = userDAO.selectByExample(example);
			if (list.size() == 1) {
				User record = list.get(0);
				String pwd = record.getPassword();
				if (pwd != null && pwd.equals(password)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean isExist(String username) {
		try {
			UserExample example = new UserExample();
			Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(username);

			List<User> list = userDAO.selectByExample(example);
			if (list.size() == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Integer register(User record) {
		if (!isExist(record.getUsername())) {
			try {
				return userDAO.insert(record);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
