package com.demo.struts2.actions;

import com.demo.hibernate.dao.UserDAO;
import com.demo.hibernate.dao.UserDAOImpl;
import com.demo.hibernate.service.UserService;
import com.demo.hibernate.service.UserServiceImpl;
import com.demo.struts2.util.Constants;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private UserServiceImpl userService;

	public LoginAction() {
		super();
		if (userService == null) {
			userService = new UserServiceImpl();
			UserDAO userDAO = new UserDAOImpl();
			userService.setUserDAO(userDAO);
		}
	}

	private String username;

	private String password;

	public void validate() {
		clearErrorsAndMessages();
		if (username == null || username.equals("")) {
			addFieldError("username", getText("login.error.username"));
		}
		if (password == null || password.equals("")) {
			addFieldError("password", getText("login.error.password"));
		}
	}

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		if (this.userService.login(username, password)) {
			ActionContext.getContext().getSession().put(Constants.USERNAME_KEY, username);
			return Action.SUCCESS;
		} else {
			super.addActionError(super.getText("login.message.failed"));
			return Action.INPUT;
		}
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
