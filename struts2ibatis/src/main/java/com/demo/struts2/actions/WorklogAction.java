package com.demo.struts2.actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.demo.ibatis.beans.Worklog;
import com.demo.ibatis.dao.WorklogDAOImpl;
import com.demo.ibatis.service.WorklogService;
import com.demo.ibatis.service.WorklogServiceImpl;
import com.demo.ibatis.util.Pager;
import com.demo.ibatis.util.SqlMapClientFactory;
import com.demo.struts2.common.PageAction;
import com.demo.struts2.util.Constants;
import com.demo.struts2.util.RegExpression;

public class WorklogAction extends PageAction {

	private static final long serialVersionUID = 1L;

	private WorklogServiceImpl worklogService;

	public WorklogAction() {
	    super();
	    if (worklogService == null) {
	        worklogService = new WorklogServiceImpl();
	        WorklogDAOImpl worklogDAO = new WorklogDAOImpl();
	        worklogDAO.setSqlMapClient(SqlMapClientFactory.getSqlMapClient());
	        worklogService.setWorklogDAO(worklogDAO);
	    }
	}

	protected String id = null;

	protected String username = null;

	protected String year = null;

	protected String month = null;

	protected String day = null;

	protected String title = null;

	protected String description = null;

	protected String logtime = null;

	public void validate() {
		clearErrorsAndMessages();

		String queryString = getRequestPath();
		if (queryString.indexOf("worklogadd!insert") != -1 || queryString.indexOf("worklogedit!update") != -1) {
			Pattern p_year = Pattern.compile(RegExpression.REG_year);
			Matcher m_year = p_year.matcher(year);
			if (!m_year.find()) {
				addFieldError("year", getText("worklog.error.year"));
			}

			Pattern p_month = Pattern.compile(RegExpression.REG_month);
			Matcher m_month = p_month.matcher(month);
			if (!m_month.find()) {
				addFieldError("month", getText("worklog.error.month"));
			}

			Pattern p_day = Pattern.compile(RegExpression.REG_day);
			Matcher m_day = p_day.matcher(day);
			if (!m_day.find()) {
				addFieldError("day", getText("worklog.error.day"));
			}

			if (title == null || title.equals("")) {
				addFieldError("title", getText("worklog.error.title"));
			}

			if (description == null || description.equals("")) {
				addFieldError("description", getText("worklog.error.description"));
			}
		}
	}

	public String init() throws Exception {
		clearErrorsAndMessages();

		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;

		super.pager = this.getWorklogService().list(super.getLoginUsername(), super.pageSize, super.pageNo);

		setSession(Constants.PAGER_WORKLOG, super.pager);

		return Constants.LIST_KEY;
	}

	public String list() throws Exception {
		clearErrorsAndMessages();

		super.pager = this.getWorklogService().list(super.getLoginUsername(), super.pageSize, super.pageNo);

		setSession(Constants.PAGER_WORKLOG, super.pager);

		return Constants.LIST_KEY;
	}

	public String add() throws Exception {
		clearErrorsAndMessages();

		reset();
		return Constants.ADD_KEY;
	}

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

	public String edit() throws Exception {
		clearErrorsAndMessages();

		if (this.getId() == null) {
			saveActionError("worklog.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			Worklog worklog = this.getWorklogService().select(Integer.valueOf(id));

			if (worklog == null) {
				saveActionError("worklog.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				bean2Form(worklog);
				return Constants.EDIT_KEY;
			}
		}
	}

	public String insert() throws Exception {
		clearErrorsAndMessages();

		Worklog worklog = new Worklog();
		worklog.setUsername(super.getLoginUsername());
		worklog.setYear(Integer.valueOf(this.year));
		worklog.setMonth(Integer.valueOf(this.month));
		worklog.setDay(Integer.valueOf(this.day));
		worklog.setTitle(this.title);
		worklog.setDescription(this.description);
		worklog.setLogtime(getLogtime());
		this.getWorklogService().insert(worklog);

		Pager pagerSession = (Pager) getSession(Constants.PAGER_WORKLOG);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		super.pager = this.getWorklogService().list(super.getLoginUsername(), super.pageSize, super.pageNo);

		saveActionMessage("worklog.message.add.success");
		return Constants.LIST_KEY;
	}

	public String update() throws Exception {
		clearErrorsAndMessages();

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

		bean2Form(worklog);

		Pager pagerSession = (Pager) getSession(Constants.PAGER_WORKLOG);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		super.pager = this.worklogService.list(super.getLoginUsername(), super.pageSize, super.pageNo);

		saveActionMessage("worklog.message.edit.success");
		return Constants.LIST_KEY;

	}

	public String delete() throws Exception {
		clearErrorsAndMessages();

		if (this.getId() == null) {
			saveActionError("worklog.message.edit.notexist");
		} else {
			this.getWorklogService().delete(Integer.valueOf(id));
			saveActionMessage("worklog.message.delete.success");
		}
		super.pager = this.getWorklogService().list(super.getLoginUsername(), super.pageSize, super.pageNo);

		return Constants.LIST_KEY;
	}

	public WorklogService getWorklogService() {
		return worklogService;
	}

	public void setWorklogService(WorklogServiceImpl worklogService) {
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
