package com.demo.spring.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.demo.spring.dao.User;
import com.demo.spring.dao.UserDAO;
import com.demo.spring.forms.RegisterForm;

public class RegisterAction extends SimpleFormController {

	UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		String method = request.getParameter("method");
		if (method == null || method.equals("init")) {
			return init(command, errors);
		} else if (method.equals("register")) {
			return register(request, response, command, errors);
		} else {
			RegisterForm registerForm = (RegisterForm) command;
			Map modle = errors.getModel();
			modle.put(getFormSessionAttributeName(), registerForm);
			return new ModelAndView(getSuccessView(), modle);
		}
	}

	public ModelAndView init(Object command, BindException errors)
			throws Exception {
		RegisterForm registerForm = (RegisterForm) command;
		Map modle = errors.getModel();
		modle.put(getFormSessionAttributeName(), registerForm);
		return new ModelAndView(getFormView(), modle);
	}

	public ModelAndView register(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		RegisterForm registerForm = (RegisterForm) command;
		if (!isExist(registerForm)) {
			add(registerForm);
			Map modle = errors.getModel();
			modle.put(getSuccessView(), registerForm);
			response.sendRedirect("login.do");
			return null;
			// return new ModelAndView(getSuccessView(), modle);
		} else {
			Map modle = errors.getModel();
			modle.put(getFormSessionAttributeName(), registerForm);
			return new ModelAndView(getFormView(), modle);
		}
	}

	public boolean isExist(RegisterForm registerForm) {
		if (userDAO.isExist(registerForm.getUsername())) {
			return true;
		} else {
			return false;
		}
	}

	public void add(RegisterForm registerForm) {
		User user = new User();
		user.setUsername(registerForm.getUsername());
		user.setPassword(registerForm.getPassword1());
		user.setEmail(registerForm.getEmail());
		userDAO.insertUser(user);
	}
}
