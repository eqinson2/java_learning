package com.demo.struts2.common;

import com.demo.struts2.util.Constants;
import com.demo.ibatis.util.Pager;

public class PageAction extends BaseAction {
	
	private static final long serialVersionUID = -7509152655359967096L;

	protected int pageSize = Constants.pageSize;

	protected int pageNo = Constants.pageNo;

	protected Pager pager;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}	
}
