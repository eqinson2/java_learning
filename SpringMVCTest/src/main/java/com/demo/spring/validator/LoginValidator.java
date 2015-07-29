package com.demo.spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.demo.spring.forms.LoginForm;

public class LoginValidator implements Validator {

	public boolean supports(Class obj) {
		return LoginForm.class.isAssignableFrom(obj);
	}

	public void validate(Object obj, Errors errors) {
		LoginForm loginForm = (LoginForm) obj;
		if (loginForm.getUsername().length() == 0) {
			errors.rejectValue("username", "login.error.username", null,
					"用户名不能为空！");
		}
		if (loginForm.getPassword().length() == 0) {
			errors.rejectValue("password", "login.error.password", null,
					"密码不能为空！");
		}
	}
}
