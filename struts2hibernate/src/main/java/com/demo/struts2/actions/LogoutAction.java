package com.demo.struts2.actions;

import com.demo.hibernate.dao.UserDAO;
import com.demo.hibernate.dao.UserDAOImpl;
import com.demo.hibernate.service.UserService;
import com.demo.hibernate.service.UserServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private UserServiceImpl userService;

	public LogoutAction() {
		super();
		if (userService == null) {
			userService = new UserServiceImpl();
			UserDAO userDAO = new UserDAOImpl();
			userService.setUserDAO(userDAO);
		}
	}

	public String execute() throws Exception {
		ActionContext.getContext().getSession().clear();
		return Action.SUCCESS;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}
}
