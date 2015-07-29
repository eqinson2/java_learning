package com.demo.struts2.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.demo.hibernate.beans.Schedule;
import com.demo.hibernate.service.ScheduleService;
import com.demo.struts2.common.PageAction;
import com.demo.struts2.util.Constants;
import com.demo.hibernate.util.Pager;
import com.demo.struts2.util.RegExpression;

public class ScheduleAction extends PageAction {

	private static final long serialVersionUID = 1L;

	private ScheduleService scheduleService;

	protected String id = null;

	protected String username = null;

	protected String year = null;

	protected String month = null;

	protected String day = null;

	protected String plan = null;


	// 新增或修改时执行表单验证
	public void validate() {
		// 清除错误消息
		clearErrorsAndMessages();

		// 取得请求参数
		String queryString = getRequestPath();
		if (queryString.indexOf("scheduleadd!insert") != -1
				|| queryString.indexOf("scheduleedit!update") != -1) {
			
			// 检查表单字段year
			Pattern p_year = Pattern.compile(RegExpression.REG_year);
			Matcher m_year = p_year.matcher(year);
			if (!m_year.find()) {
				addFieldError("year", getText("schedule.error.year"));
			}
			
			// 检查表单字段month
			Pattern p_month = Pattern.compile(RegExpression.REG_month);
			Matcher m_month = p_month.matcher(month);
			if (!m_month.find()) {
				addFieldError("month", getText("schedule.error.month"));
			}
			
			// 检查表单字段day
			Pattern p_day = Pattern.compile(RegExpression.REG_day);
			Matcher m_day = p_day.matcher(day);
			if (!m_day.find()) {
				addFieldError("day", getText("schedule.error.day"));
			}

			// 检查表单字段plan
			if (plan == null || plan.equals("")) {
				addFieldError("plan", getText("schedule.error.plan"));
			}
		}
	}

	// 请求scheduleInit.do的处理函数
	public String init() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// 重设分页参数
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;

		// 取得当前分页数据
		super.pager = this.getScheduleService().list(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		// 保存分页数据
		setSession(Constants.PAGER_SCHEDULE, super.pager);

		return Constants.LIST_KEY;
	}

	// 请求scheduleList.do的处理函数
	public String list() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// 取得当前分页数据
		super.pager = this.getScheduleService().list(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		// 保存分页数据
		setSession(Constants.PAGER_SCHEDULE, super.pager);

		return Constants.LIST_KEY;
	}

	// 请求scheduleAdd.do的处理函数
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
		setPlan(null);
	}

	// 给表单字段赋值
	private void bean2Form(Schedule schedule) {
		setId(schedule.getId().toString());
		setUsername(schedule.getUsername());
		setYear(schedule.getYear().toString());
		setMonth(schedule.getMonth().toString());
		setDay(schedule.getDay().toString());
		setPlan(schedule.getPlan());
	}

	// 请求scheduleEdit.do的处理函数
	public String edit() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// id为空时返回错误
		if (this.getId() == null) {
			saveActionError("schedule.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// 查询数据表
			Schedule schedule = this.getScheduleService().select(Integer.valueOf(id));

			// 不存在时返回错误
			if (schedule == null) {
				saveActionError("schedule.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// 给表单字段赋值
				bean2Form(schedule);
				return Constants.EDIT_KEY;
			}
		}
	}

	// 请求scheduleInsert.do的处理函数
	public String insert() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();
		
		// 插入数据表
		Schedule schedule = new Schedule();
		schedule.setUsername(super.getLoginUsername());
		schedule.setYear(Integer.valueOf(this.getYear()));
		schedule.setMonth(Integer.valueOf(this.getMonth()));
		schedule.setDay(Integer.valueOf(this.getDay()));
		schedule.setPlan(this.getPlan());
		this.getScheduleService().insert(schedule);
		
		// 取得缓存的分页参数
		Pager pagerSession = (Pager) getSession(Constants.PAGER_SCHEDULE);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		// 查询当前页的数据
		super.pager = this.getScheduleService().list(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		
		// 保存成功信息
		saveActionMessage("schedule.message.add.success");
		return Constants.LIST_KEY;
	}

	// 请求scheduleUpdate.do的处理函数
	public String update() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// 更新数据表
		Schedule schedule = new Schedule();
		schedule.setId(new Integer(id));
		schedule.setUsername(super.getLoginUsername());
		schedule.setYear(Integer.valueOf(this.getYear()));
		schedule.setMonth(Integer.valueOf(this.getMonth()));
		schedule.setDay(Integer.valueOf(this.getDay()));
		schedule.setPlan(this.getPlan());
		this.getScheduleService().update(schedule);

		// 给表单字段赋值
		bean2Form(schedule);
		
		// 取得缓存的分页参数
		Pager pagerSession = (Pager) getSession(Constants.PAGER_SCHEDULE);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		// 查询当前页的数据
		super.pager = this.getScheduleService().list(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		saveActionMessage("schedule.message.edit.success");
		return Constants.LIST_KEY;

	}

	// 请求scheduleDelete.do的处理函数
	public String delete() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// id为空时返回错误
		if (this.getId() == null) {
			saveActionError("schedule.message.edit.notexist");
		} else {
			// 删除数据
			scheduleService.delete(Integer.valueOf(id));
			saveActionMessage("schedule.message.delete.success");
		}
		// 取得当前页的数据
		super.pager = this.getScheduleService().list(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		return Constants.LIST_KEY;
	}

	public ScheduleService getScheduleService() {
		return scheduleService;
	}

	public void setScheduleService(ScheduleService scheduleService) {
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
