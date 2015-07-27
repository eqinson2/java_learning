package com.demo.ibatis.service;

import com.demo.ibatis.beans.User;
import com.demo.ibatis.dao.UserDAOImpl;
import com.demo.ibatis.service.UserServiceImpl;
import com.demo.ibatis.util.SqlMapClientFactory;

import junit.framework.TestCase;

public class UserServiceTest extends TestCase {

	public UserServiceImpl userService;

	public UserServiceTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		userService = new UserServiceImpl();
		UserDAOImpl userDAO = new UserDAOImpl();
		userDAO.setSqlMapClient(SqlMapClientFactory.getSqlMapClient());
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
		record.setUsername("test");
		record.setPassword("123");
		record.setEmail("lzb_box163.com");
		userService.register(record);
		assertTrue(userService.isExist("test"));
	}
}
