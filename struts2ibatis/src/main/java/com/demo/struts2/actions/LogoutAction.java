package com.demo.struts2.actions;

import com.demo.ibatis.dao.UserDAOImpl;
import com.demo.ibatis.service.UserService;
import com.demo.ibatis.service.UserServiceImpl;
import com.demo.ibatis.util.SqlMapClientFactory;
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
			UserDAOImpl userDAO = new UserDAOImpl();
			userDAO.setSqlMapClient(SqlMapClientFactory.getSqlMapClient());
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
