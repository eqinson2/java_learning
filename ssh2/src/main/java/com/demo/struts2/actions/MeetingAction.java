package com.demo.struts2.actions;

import com.demo.hibernate.beans.Meeting;
import com.demo.hibernate.service.MeetingService;
import com.demo.struts2.common.PageAction;
import com.demo.struts2.util.Constants;
import com.demo.hibernate.util.Pager;

public class MeetingAction extends PageAction {

	private static final long serialVersionUID = 1L;

	private MeetingService meetingService;

	protected String id = null;

	protected String sender = null;

	protected String starttime = null;

	protected String endtime = null;

	protected String address = null;

	protected String title = null;

	protected String content = null;


	// 新增或修改时执行表单验证
	public void validate() {
		// 清除错误消息
		clearErrorsAndMessages();

		// 取得请求参数
		String queryString = getRequestPath();
		if (queryString.indexOf("meetingadd!insert") != -1
				|| queryString.indexOf("meetingedit!update") != -1) {
			// 检查表单字段title
			if (title == null || title.equals("")) {
				addFieldError("title",getText("meeting.error.title"));
			}

			// 检查表单字段content
			if (content == null || content.equals("")) {
				addFieldError("content", getText("meeting.error.content"));
			}
		}
	}

	// 请求meetingInit.do的处理函数
	public String init() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// 重设分页参数
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;

		// 取得当前分页数据
		super.pager = this.getMeetingService().list(super.pageSize, super.pageNo);

		// 保存分页数据
		setSession(Constants.PAGER_MEETING, super.pager);

		return Constants.LIST_KEY;
	}

	// 请求meetingList.do的处理函数
	public String list() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// 取得当前分页数据
		super.pager = this.getMeetingService().list(super.pageSize, super.pageNo);

		// 保存分页数据
		setSession(Constants.PAGER_MEETING, super.pager);

		return Constants.LIST_KEY;
	}

	// 请求meetingAdd.do的处理函数
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
		setSender(null);
		setStarttime(null);
		setEndtime(null);
		setAddress(null);
		setTitle(null);
		setContent(null);
	}

	// 给表单字段赋值
	private void bean2Form(Meeting meeting) {
		setId(meeting.getId().toString());
		setSender(meeting.getSender());
		setStarttime(meeting.getStarttime());
		setEndtime(meeting.getEndtime());
		setAddress(meeting.getAddress());
		setTitle(meeting.getTitle());
		setContent(meeting.getContent());
	}

	// 请求meetingEdit.do的处理函数
	public String edit() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// id为空时返回错误
		if (this.getId() == null) {
			saveActionError("meeting.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// 查询数据表
			Meeting meeting = this.getMeetingService().select(Integer.valueOf(id));

			// 不存在时返回错误
			if (meeting == null) {
				saveActionError("meeting.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// 给表单字段赋值
				bean2Form(meeting);
				return Constants.EDIT_KEY;
			}
		}
	}

	// 请求meetingInsert.do的处理函数
	public String insert() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();
		
		// 插入数据表
		Meeting meeting = new Meeting();
		meeting.setSender(super.getLoginUsername());
		meeting.setStarttime(this.getStarttime());
		meeting.setEndtime(this.getEndtime());
		meeting.setAddress(this.getAddress());
		meeting.setTitle(this.getTitle());
		meeting.setContent(this.getContent());
		this.getMeetingService().insert(meeting);
		
		// 取得缓存的分页参数
		Pager pagerSession = (Pager) getSession(Constants.PAGER_MEETING);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		// 查询当前页的数据
		super.pager = this.getMeetingService().list(super.pageSize, super.pageNo);
		
		// 保存成功信息
		saveActionMessage("meeting.message.add.success");
		return Constants.LIST_KEY;
	}

	// 请求meetingUpdate.do的处理函数
	public String update() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// 更新数据表
		Meeting meeting = new Meeting();
		meeting.setId(new Integer(id));
		meeting.setSender(super.getLoginUsername());
		meeting.setStarttime(this.getStarttime());
		meeting.setEndtime(this.getEndtime());
		meeting.setAddress(this.getAddress());
		meeting.setTitle(this.getTitle());
		meeting.setContent(this.getContent());
		this.getMeetingService().update(meeting);

		// 给表单字段赋值
		bean2Form(meeting);
		
		// 取得缓存的分页参数
		Pager pagerSession = (Pager) getSession(Constants.PAGER_MEETING);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		// 查询当前页的数据
		super.pager = this.getMeetingService().list(super.pageSize, super.pageNo);

		saveActionMessage("meeting.message.edit.success");
		return Constants.LIST_KEY;

	}

	// 请求meetingDelete.do的处理函数
	public String delete() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// id为空时返回错误
		if (this.getId() == null) {
			saveActionError("meeting.message.edit.notexist");
		} else {
			// 删除数据
			this.getMeetingService().delete(Integer.valueOf(id));
			saveActionMessage("meeting.message.delete.success");
		}
		// 取得当前页的数据
		super.pager = this.getMeetingService().list(super.pageSize, super.pageNo);

		return Constants.LIST_KEY;
	}

	public MeetingService getMeetingService() {
		return meetingService;
	}

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
