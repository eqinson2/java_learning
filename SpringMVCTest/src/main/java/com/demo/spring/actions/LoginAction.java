package com.demo.spring.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.demo.spring.dao.UserDAO;
import com.demo.spring.forms.LoginForm;
import com.demo.spring.util.Constants;

public class LoginAction extends SimpleFormController {
	
	UserDAO userDAO;	

    public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {
        LoginForm loginForm = (LoginForm) command;
        if (isValid(loginForm)) {
            request.getSession().setAttribute(Constants.USERNAME_KEY, loginForm.getUsername());
            return new ModelAndView(getSuccessView());
        } else {
            Map modle = errors.getModel();
            modle.put("loginForm", loginForm);
            return new ModelAndView(getFormView(), modle);
        }
    }

	public boolean isValid(LoginForm loginForm) {
		if(userDAO.isValid(loginForm.getUsername(), loginForm.getPassword())) {
			return true;
		} else {
			return false;
		}
	}
}
