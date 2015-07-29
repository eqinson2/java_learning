package com.demo.struts2.common;

import java.util.Map;

import com.demo.struts2.util.Constants;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorizationInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 2575538469018873724L;

	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation invocation) throws Exception {
		Map session = invocation.getInvocationContext().getSession();
		String username = (String) session.get(Constants.USERNAME_KEY);
		if (null != username && !username.equals("")) {
			// 合法用户
			return invocation.invoke();
		} else {
			System.out.println("拦截器：用户未登录---");
			return Action.LOGIN;
		}
	}
}
