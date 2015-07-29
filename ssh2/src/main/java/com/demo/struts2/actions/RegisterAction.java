package com.demo.struts2.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.demo.hibernate.beans.User;
import com.demo.hibernate.service.UserService;
import com.demo.struts2.common.BaseAction;
import com.demo.struts2.util.RegExpression;
import com.opensymphony.xwork2.Action;

public class RegisterAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private UserService userService;

	private String username;

	private String password1;

	private String password2;

	private String email;

	public void validate() {
		clearErrorsAndMessages();
		String queryString = getRequestPath();
		if (queryString.indexOf("register!register") != -1) {
			if (username == null || username.equals("")) {
				addFieldError("username", getText("register.error.username"));
			}
			if (password1 == null || password1.equals("")) {
				addFieldError("password1", getText("register.error.password1"));
			}
			if (password2 == null || !password2.equals(password1)) {
				addFieldError("password2", getText("register.error.password2"));
			}
			Pattern pattern = Pattern.compile(RegExpression.REG_email);
			Matcher m = pattern.matcher(email);
			if (!m.find()) {
				addFieldError("email", getText("register.error.email"));
			}
		}
	}

	public String init() throws Exception {
		setUsername(null);
		setPassword1(null);
		setPassword2(null);
		setEmail(null);
		return Action.INPUT;
	}

	public String register() throws Exception {
		if (getUserService().isExist(username)) {
			super.addActionError(super.getText("register.message.failed"));
			return Action.INPUT;
		} else {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password1);
			user.setEmail(email);
			getUserService().register(user);
			return Action.SUCCESS;
		}
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
