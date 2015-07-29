package com.demo.struts2.actions;

import com.demo.hibernate.service.UserService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private UserService userService;

	public String execute() throws Exception {
		ActionContext.getContext().getSession().clear();
		return Action.SUCCESS;			
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}	
}
