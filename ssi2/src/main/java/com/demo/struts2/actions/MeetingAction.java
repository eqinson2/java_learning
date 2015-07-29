package com.demo.struts2.actions;

import com.demo.ibatis.beans.Meeting;
import com.demo.ibatis.service.MeetingService;
import com.demo.ibatis.util.Pager;
import com.demo.struts2.common.PageAction;
import com.demo.struts2.util.Constants;

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

	public void validate() {
		clearErrorsAndMessages();

		String queryString = getRequestPath();
		if (queryString.indexOf("meetingadd!insert") != -1 || queryString.indexOf("meetingedit!update") != -1) {
			if (title == null || title.equals("")) {
				addFieldError("title", getText("meeting.error.title"));
			}

			if (content == null || content.equals("")) {
				addFieldError("content", getText("meeting.error.content"));
			}
		}
	}

	public String init() throws Exception {
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

	public String list() throws Exception {
		clearErrorsAndMessages();

		super.pager = this.getMeetingService().list(super.pageSize, super.pageNo);

		setSession(Constants.PAGER_MEETING, super.pager);

		return Constants.LIST_KEY;
	}

	public String add() throws Exception {
		clearErrorsAndMessages();

		reset();
		return Constants.ADD_KEY;
	}

	private void reset() {
		setId(null);
		setSender(null);
		setStarttime(null);
		setEndtime(null);
		setAddress(null);
		setTitle(null);
		setContent(null);
	}

	private void bean2Form(Meeting meeting) {
		setId(meeting.getId().toString());
		setSender(meeting.getSender());
		setStarttime(meeting.getStarttime());
		setEndtime(meeting.getEndtime());
		setAddress(meeting.getAddress());
		setTitle(meeting.getTitle());
		setContent(meeting.getContent());
	}

	public String edit() throws Exception {
		clearErrorsAndMessages();

		if (this.getId() == null) {
			saveActionError("meeting.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			Meeting meeting = this.getMeetingService().select(Integer.valueOf(id));

			if (meeting == null) {
				saveActionError("meeting.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				bean2Form(meeting);
				return Constants.EDIT_KEY;
			}
		}
	}

	public String insert() throws Exception {
		clearErrorsAndMessages();

		Meeting meeting = new Meeting();
		meeting.setSender(super.getLoginUsername());
		meeting.setStarttime(this.getStarttime());
		meeting.setEndtime(this.getEndtime());
		meeting.setAddress(this.getAddress());
		meeting.setTitle(this.getTitle());
		meeting.setContent(this.getContent());
		this.getMeetingService().insert(meeting);

		Pager pagerSession = (Pager) getSession(Constants.PAGER_MEETING);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		super.pager = this.getMeetingService().list(super.pageSize, super.pageNo);

		saveActionMessage("meeting.message.add.success");
		return Constants.LIST_KEY;
	}

	public String update() throws Exception {
		clearErrorsAndMessages();

		Meeting meeting = new Meeting();
		meeting.setId(new Integer(id));
		meeting.setSender(super.getLoginUsername());
		meeting.setStarttime(this.getStarttime());
		meeting.setEndtime(this.getEndtime());
		meeting.setAddress(this.getAddress());
		meeting.setTitle(this.getTitle());
		meeting.setContent(this.getContent());
		this.getMeetingService().update(meeting);

		bean2Form(meeting);

		Pager pagerSession = (Pager) getSession(Constants.PAGER_MEETING);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		super.pager = this.getMeetingService().list(super.pageSize, super.pageNo);

		saveActionMessage("meeting.message.edit.success");
		return Constants.LIST_KEY;

	}

	public String delete() throws Exception {
		clearErrorsAndMessages();

		if (this.getId() == null) {
			saveActionError("meeting.message.edit.notexist");
		} else {
			this.getMeetingService().delete(Integer.valueOf(id));
			saveActionMessage("meeting.message.delete.success");
		}
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
