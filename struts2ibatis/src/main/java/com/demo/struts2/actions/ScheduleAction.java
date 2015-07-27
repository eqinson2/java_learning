package com.demo.struts2.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.demo.ibatis.beans.Schedule;
import com.demo.ibatis.dao.ScheduleDAOImpl;
import com.demo.ibatis.service.ScheduleService;
import com.demo.ibatis.service.ScheduleServiceImpl;
import com.demo.ibatis.util.Pager;
import com.demo.ibatis.util.SqlMapClientFactory;
import com.demo.struts2.common.PageAction;
import com.demo.struts2.util.Constants;
import com.demo.struts2.util.RegExpression;

public class ScheduleAction extends PageAction {

	private static final long serialVersionUID = 1L;

	private ScheduleServiceImpl scheduleService;

	public ScheduleAction() {
	    super();
	    if (scheduleService == null) {
	        scheduleService = new ScheduleServiceImpl();
	        ScheduleDAOImpl scheduleDAO = new ScheduleDAOImpl();
	        scheduleDAO.setSqlMapClient(SqlMapClientFactory.getSqlMapClient());
	        scheduleService.setScheduleDAO(scheduleDAO);
	    }
	}

	protected String id = null;

	protected String username = null;

	protected String year = null;

	protected String month = null;

	protected String day = null;

	protected String plan = null;

	public void validate() {
		clearErrorsAndMessages();

		String queryString = getRequestPath();
		if (queryString.indexOf("scheduleadd!insert") != -1 || queryString.indexOf("scheduleedit!update") != -1) {

			Pattern p_year = Pattern.compile(RegExpression.REG_year);
			Matcher m_year = p_year.matcher(year);
			if (!m_year.find()) {
				addFieldError("year", getText("schedule.error.year"));
			}

			Pattern p_month = Pattern.compile(RegExpression.REG_month);
			Matcher m_month = p_month.matcher(month);
			if (!m_month.find()) {
				addFieldError("month", getText("schedule.error.month"));
			}

			Pattern p_day = Pattern.compile(RegExpression.REG_day);
			Matcher m_day = p_day.matcher(day);
			if (!m_day.find()) {
				addFieldError("day", getText("schedule.error.day"));
			}

			if (plan == null || plan.equals("")) {
				addFieldError("plan", getText("schedule.error.plan"));
			}
		}
	}

	public String init() throws Exception {
		clearErrorsAndMessages();

		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;

		super.pager = this.getScheduleService().list(super.getLoginUsername(), super.pageSize, super.pageNo);

		setSession(Constants.PAGER_SCHEDULE, super.pager);

		return Constants.LIST_KEY;
	}

	public String list() throws Exception {
		clearErrorsAndMessages();

		super.pager = this.getScheduleService().list(super.getLoginUsername(), super.pageSize, super.pageNo);

		setSession(Constants.PAGER_SCHEDULE, super.pager);

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
		setPlan(null);
	}

	private void bean2Form(Schedule schedule) {
		setId(schedule.getId().toString());
		setUsername(schedule.getUsername());
		setYear(schedule.getYear().toString());
		setMonth(schedule.getMonth().toString());
		setDay(schedule.getDay().toString());
		setPlan(schedule.getPlan());
	}

	public String edit() throws Exception {
		clearErrorsAndMessages();

		if (this.getId() == null) {
			saveActionError("schedule.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			Schedule schedule = this.getScheduleService().select(Integer.valueOf(id));

			if (schedule == null) {
				saveActionError("schedule.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				bean2Form(schedule);
				return Constants.EDIT_KEY;
			}
		}
	}

	public String insert() throws Exception {
		clearErrorsAndMessages();

		Schedule schedule = new Schedule();
		schedule.setUsername(super.getLoginUsername());
		schedule.setYear(Integer.valueOf(this.getYear()));
		schedule.setMonth(Integer.valueOf(this.getMonth()));
		schedule.setDay(Integer.valueOf(this.getDay()));
		schedule.setPlan(this.getPlan());
		this.getScheduleService().insert(schedule);

		Pager pagerSession = (Pager) getSession(Constants.PAGER_SCHEDULE);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		super.pager = this.getScheduleService().list(super.getLoginUsername(), super.pageSize, super.pageNo);

		saveActionMessage("schedule.message.add.success");
		return Constants.LIST_KEY;
	}

	public String update() throws Exception {
		clearErrorsAndMessages();

		Schedule schedule = new Schedule();
		schedule.setId(new Integer(id));
		schedule.setUsername(super.getLoginUsername());
		schedule.setYear(Integer.valueOf(this.getYear()));
		schedule.setMonth(Integer.valueOf(this.getMonth()));
		schedule.setDay(Integer.valueOf(this.getDay()));
		schedule.setPlan(this.getPlan());
		this.getScheduleService().update(schedule);

		bean2Form(schedule);

		Pager pagerSession = (Pager) getSession(Constants.PAGER_SCHEDULE);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		super.pager = this.getScheduleService().list(super.getLoginUsername(), super.pageSize, super.pageNo);

		saveActionMessage("schedule.message.edit.success");
		return Constants.LIST_KEY;

	}

	public String delete() throws Exception {
		clearErrorsAndMessages();

		if (this.getId() == null) {
			saveActionError("schedule.message.edit.notexist");
		} else {
			scheduleService.delete(Integer.valueOf(id));
			saveActionMessage("schedule.message.delete.success");
		}
		super.pager = this.getScheduleService().list(super.getLoginUsername(), super.pageSize, super.pageNo);

		return Constants.LIST_KEY;
	}

	public ScheduleService getScheduleService() {
		return scheduleService;
	}

	public void setScheduleService(ScheduleServiceImpl scheduleService) {
		this.scheduleService = scheduleService;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
