package com.demo.struts2.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String str1;

	private String str2;

	public String execute() throws Exception {
		if (!str1.equals("") && !str2.equals("")) {
			ActionContext.getContext().getSession().put("str1", str1);
			ActionContext.getContext().getSession().put("str2", str2);
			return Action.SUCCESS;
		} else {
			return Action.INPUT;
		}
	}

	public String getStr1() {
		return str1;
	}

	public void setStr1(String str1) {
		this.str1 = str1;
	}

	public String getStr2() {
		return str2;
	}

	public void setStr2(String str2) {
		this.str2 = str2;
	}

}
