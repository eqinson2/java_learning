package com.demo.spring.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.demo.spring.forms.TestForm;

public class TestAction extends SimpleFormController {

	@SuppressWarnings("unchecked")
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		TestForm testForm = (TestForm) command;
		if (testForm.getStr1().equals("admin") && testForm.getStr2().equals("admin")) {
			request.getSession().setAttribute("str1", testForm.getStr1());
			request.getSession().setAttribute("str2", testForm.getStr2());
			return new ModelAndView(getSuccessView());
		} else {
			Map modle = errors.getModel();
			modle.put("testForm", testForm);
			return new ModelAndView(getFormView(), modle);
		}
	}
}
