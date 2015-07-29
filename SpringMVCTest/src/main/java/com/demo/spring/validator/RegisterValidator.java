package com.demo.spring.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.demo.spring.forms.RegisterForm;
import com.demo.spring.util.RegExpression;

public class RegisterValidator implements Validator {

	public boolean supports(Class obj) {
		return RegisterForm.class.isAssignableFrom(obj);
	}

	public void validate(Object obj, Errors errors) {
		RegisterForm registerForm = (RegisterForm) obj;
		String username = registerForm.getUsername();
		String password1 = registerForm.getPassword1();
		String password2 = registerForm.getPassword2();
		String email = registerForm.getEmail();

		if (username == null || username.equals("")) {
			errors.rejectValue("username", "register.error.username", null,
					"用户名不能为空!");
		}
		if (password1 == null || password1.equals("")) {
			errors.rejectValue("password1", "register.error.password1", null,
					"密码不能为空!");
		}
		if (password2 == null || !password2.equals(password1)) {
			errors.rejectValue("password2", "register.error.password2", null,
					"两个密码不相等!");
		}

		Pattern pattern = Pattern.compile(RegExpression.REG_email);
		Matcher m = pattern.matcher(email);
		if (!m.find()) {
			errors.rejectValue("email", "register.error.email", null, "地址不合法!");
		}
	}
}
