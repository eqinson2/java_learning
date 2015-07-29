package com.demo.struts2.actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.demo.hibernate.beans.Worklog;
import com.demo.hibernate.service.WorklogService;
import com.demo.struts2.common.PageAction;
import com.demo.struts2.util.Constants;
import com.demo.hibernate.util.Pager;
import com.demo.struts2.util.RegExpression;

public class WorklogAction extends PageAction {

	private static final long serialVersionUID = 1L;

	private WorklogService worklogService;

	protected String id = null;

	protected String username = null;

	protected String year = null;

	protected String month = null;

	protected String day = null;

	protected String title = null;

	protected String description = null;

	protected String logtime = null;
	
	// 新增或修改时执行表单验证
	public void validate() {
		// 清除错误消息
		clearErrorsAndMessages();

		// 取得请求参数
		String queryString = getRequestPath();
		if (queryString.indexOf("worklogadd!insert") != -1
				|| queryString.indexOf("worklogedit!update") != -1) {
			// 检查表单字段year
			Pattern p_year = Pattern.compile(RegExpression.REG_year);
			Matcher m_year = p_year.matcher(year);
			if (!m_year.find()) {
				addFieldError("year", getText("worklog.error.year"));
			}

			// 检查表单字段month
			Pattern p_month = Pattern.compile(RegExpression.REG_month);
			Matcher m_month = p_month.matcher(month);
			if (!m_month.find()) {
				addFieldError("month", getText("worklog.error.month"));
			}

			// 检查表单字段day
			Pattern p_day = Pattern.compile(RegExpression.REG_day);
			Matcher m_day = p_day.matcher(day);
			if (!m_day.find()) {
				addFieldError("day", getText("worklog.error.day"));
			}

			// 检查表单字段title
			if (title == null || title.equals("")) {
				addFieldError("title", getText("worklog.error.title"));
			}

			// 检查表单字段description
			if (description == null || description.equals("")) {
				addFieldError("description", getText("worklog.error.description"));
			}
		}
	}

	// 请求worklogInit.do的处理函数
	public String init() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// 重设分页参数
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;

		// 取得当前分页数据
		super.pager = this.getWorklogService().list(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		// 保存分页数据
		setSession(Constants.PAGER_WORKLOG, super.pager);

		return Constants.LIST_KEY;
	}

	// 请求worklogList.do的处理函数
	public String list() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// 取得当前分页数据
		super.pager = this.getWorklogService().list(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		// 保存分页数据
		setSession(Constants.PAGER_WORKLOG, super.pager);

		return Constants.LIST_KEY;
	}

	// 请求worklogAdd.do的处理函数
	public String add() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// 重设各表单字段
		reset();
		return Constants.ADD_KEY;
	}

	// 重设各表单字段
	private void reset() {
		setId(null);
		setUsername(null);
		setYear(null);
		setMonth(null);
		setDay(null);
		setTitle(null);
		setDescription(null);
		setLogtime(null);
	}

	// 给表单字段赋值
	private void bean2Form(Worklog worklog) {
		setId(worklog.getId().toString());
		setUsername(worklog.getUsername());
		setYear(worklog.getYear().toString());
		setMonth(worklog.getMonth().toString());
		setDay(worklog.getDay().toString());
		setTitle(worklog.getTitle());
		setDescription(worklog.getDescription());
		setLogtime(worklog.getLogtime());
	}

	// 请求worklogEdit.do的处理函数
	public String edit() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// id为空时返回错误
		if (this.getId() == null) {
			saveActionError("worklog.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// 查询数据表
			Worklog worklog = this.getWorklogService().select(Integer.valueOf(id));

			// 不存在时返回错误
			if (worklog == null) {
				saveActionError("worklog.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// 给表单字段赋值
				bean2Form(worklog);
				return Constants.EDIT_KEY;
			}
		}
	}

	// 请求worklogInsert.do的处理函数
	public String insert() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();
		
		// 插入数据表
		Worklog worklog = new Worklog();
		worklog.setUsername(super.getLoginUsername());
		worklog.setYear(Integer.valueOf(this.year));
		worklog.setMonth(Integer.valueOf(this.month));
		worklog.setDay(Integer.valueOf(this.day));
		worklog.setTitle(this.title);
		worklog.setDescription(this.description);
		worklog.setLogtime(getLogtime());
		this.getWorklogService().insert(worklog);		

		// 取得缓存的分页参数
		Pager pagerSession = (Pager) getSession(Constants.PAGER_WORKLOG);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		// 查询当前页的数据
		super.pager = this.getWorklogService().list(super
				.getLoginUsername(), super.pageSize, super.pageNo);
	
		// 保存成功信息
		saveActionMessage("worklog.message.add.success");
		return Constants.LIST_KEY;
	}

	// 请求worklogUpdate.do的处理函数
	public String update() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// 更新数据表
		Worklog worklog = new Worklog();
		worklog.setId(new Integer(id));
		worklog.setUsername(super.getLoginUsername());
		worklog.setYear(Integer.valueOf(this.getYear()));
		worklog.setMonth(Integer.valueOf(this.getMonth()));
		worklog.setDay(Integer.valueOf(this.getDay()));
		worklog.setTitle(this.getTitle());
		worklog.setDescription(this.getDescription());
		worklog.setLogtime(this.getLogtime());
		worklogService.update(worklog);

		// 给表单字段赋值
		bean2Form(worklog);
		
		// 取得缓存的分页参数
		Pager pagerSession = (Pager) getSession(Constants.PAGER_WORKLOG);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		// 查询当前页的数据
		super.pager = this.worklogService.list(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		saveActionMessage("worklog.message.edit.success");
		return Constants.LIST_KEY;

	}

	// 请求worklogDelete.do的处理函数
	public String delete() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// id为空时返回错误
		if (this.getId() == null) {
			saveActionError("worklog.message.edit.notexist");
		} else {
			// 删除数据
			this.getWorklogService().delete(Integer.valueOf(id));
			saveActionMessage("worklog.message.delete.success");
		}
		// 取得当前页的数据
		super.pager = this.getWorklogService().list(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		return Constants.LIST_KEY;
	}

	public WorklogService getWorklogService() {
		return worklogService;
	}

	public void setWorklogService(WorklogService worklogService) {
		this.worklogService = worklogService;
	}

	public String getLogtime() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");			
		logtime = f.format(new Date());
		return logtime;
	}

	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
