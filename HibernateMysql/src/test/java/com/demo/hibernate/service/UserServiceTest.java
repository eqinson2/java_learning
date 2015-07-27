package com.demo.hibernate.service;

import com.demo.hibernate.beans.User;
import com.demo.hibernate.dao.UserDAO;
import com.demo.hibernate.dao.UserDAOImpl;
import com.demo.hibernate.service.UserServiceImpl;

import junit.framework.TestCase;

public class UserServiceTest extends TestCase {

	public UserServiceImpl userService;

	public UserServiceTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		userService = new UserServiceImpl();
		UserDAO userDAO = new UserDAOImpl();
		userService.setUserDAO(userDAO);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testLogin() throws Exception {
		assertTrue(userService.login("admin", "admin"));
	}

	public void testIsExist() throws Exception {
		assertTrue(userService.isExist("admin"));
	}

	public void testInsert() throws Exception {
		User record = new User();
		record.setUsername("eqinson123");
		record.setPassword("123");
		record.setEmail("lzb_box163.com");
		userService.register(record);
		assertTrue(userService.isExist("test"));
	}
}
