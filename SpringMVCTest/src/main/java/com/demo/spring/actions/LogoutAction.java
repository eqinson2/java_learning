package com.demo.spring.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class LogoutAction extends SimpleFormController {

	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		request.getSession().invalidate();
		response.sendRedirect("login.do");
		return null;
		//return new ModelAndView(getSuccessView());
	}
}
