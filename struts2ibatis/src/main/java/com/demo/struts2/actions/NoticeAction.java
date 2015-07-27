package com.demo.struts2.actions;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.demo.ibatis.beans.Notice;
import com.demo.ibatis.dao.NoticeDAOImpl;
import com.demo.ibatis.service.NoticeService;
import com.demo.ibatis.service.NoticeServiceImpl;
import com.demo.ibatis.util.Pager;
import com.demo.ibatis.util.SqlMapClientFactory;
import com.demo.struts2.common.PageAction;
import com.demo.struts2.util.Constants;

public class NoticeAction extends PageAction {

	private static final long serialVersionUID = 1L;

	private NoticeServiceImpl noticeService;

	public NoticeAction() {
		super();
		if (noticeService == null) {
			noticeService = new NoticeServiceImpl();
			NoticeDAOImpl noticeDAO = new NoticeDAOImpl();
			noticeDAO.setSqlMapClient(SqlMapClientFactory.getSqlMapClient());
			noticeService.setNoticeDAO(noticeDAO);
		}
	}

	protected String id = null;

	protected String sender = null;

	protected String title = null;

	protected String content = null;

	protected String sendtime = null;

	public void validate() {
		clearErrorsAndMessages();

		String queryString = getRequestPath();
		if (queryString.indexOf("noticeadd!insert") != -1 || queryString.indexOf("noticeedit!update") != -1) {
			if (title == null || title.equals("")) {
				addFieldError("title", getText("notice.error.title"));
			}

			if (content == null || content.equals("")) {
				addFieldError("content", getText("notice.error.content"));
			}
		}
	}

	public String init() throws Exception {
		clearErrorsAndMessages();

		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;

		super.pager = this.getNoticeService().list(super.pageSize, super.pageNo);

		setSession(Constants.PAGER_NOTICE, super.pager);

		return Constants.LIST_KEY;
	}

	public String list() throws Exception {
		clearErrorsAndMessages();

		super.pager = this.getNoticeService().list(super.pageSize, super.pageNo);

		setSession(Constants.PAGER_NOTICE, super.pager);

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
		setTitle(null);
		setContent(null);
		setSendtime(null);
	}

	private void bean2Form(Notice notice) {
		setId(notice.getId().toString());
		setSender(notice.getSender());
		setTitle(notice.getTitle());
		setContent(notice.getContent());
		setSendtime(notice.getSendtime());
	}

	public String edit() throws Exception {
		clearErrorsAndMessages();

		if (this.getId() == null) {
			saveActionError("notice.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			Notice notice = this.getNoticeService().select(Integer.valueOf(id));

			if (notice == null) {
				saveActionError("notice.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				bean2Form(notice);
				return Constants.EDIT_KEY;
			}
		}
	}

	public String insert() throws Exception {
		clearErrorsAndMessages();

		Notice notice = new Notice();
		notice.setSender(super.getLoginUsername());
		notice.setTitle(this.getTitle());
		notice.setContent(this.getContent());
		notice.setSendtime(this.getSendtime());
		this.getNoticeService().insert(notice);

		Pager pagerSession = (Pager) getSession(Constants.PAGER_NOTICE);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		super.pager = this.getNoticeService().list(super.pageSize, super.pageNo);

		saveActionMessage("notice.message.add.success");
		return Constants.LIST_KEY;
	}

	public String update() throws Exception {
		clearErrorsAndMessages();

		Notice notice = new Notice();
		notice.setId(new Integer(id));
		notice.setSender(super.getLoginUsername());
		notice.setTitle(this.getTitle());
		notice.setContent(this.getContent());
		notice.setSendtime(this.getSendtime());
		this.getNoticeService().update(notice);

		bean2Form(notice);

		Pager pagerSession = (Pager) getSession(Constants.PAGER_NOTICE);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		super.pager = this.getNoticeService().list(super.pageSize, super.pageNo);

		saveActionMessage("notice.message.edit.success");
		return Constants.LIST_KEY;

	}

	public String delete() throws Exception {
		clearErrorsAndMessages();

		if (this.getId() == null) {
			saveActionError("notice.message.edit.notexist");
		} else {
			this.getNoticeService().delete(Integer.valueOf(id));
			saveActionMessage("notice.message.delete.success");
		}
		super.pager = this.getNoticeService().list(super.pageSize, super.pageNo);

		return Constants.LIST_KEY;
	}

	public NoticeService getNoticeService() {
		return noticeService;
	}

	public void setNoticeService(NoticeServiceImpl noticeService) {
		this.noticeService = noticeService;
	}

	public String getSendtime() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sendtime = f.format(new Date());
		return sendtime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
