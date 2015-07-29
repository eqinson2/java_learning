package com.demo.struts2.actions;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.demo.hibernate.beans.Notice;
import com.demo.hibernate.service.NoticeService;
import com.demo.struts2.common.PageAction;
import com.demo.struts2.util.Constants;
import com.demo.hibernate.util.Pager;

public class NoticeAction extends PageAction {

	private static final long serialVersionUID = 1L;

	private NoticeService noticeService;

	protected String id = null;

	protected String sender = null;

	protected String title = null;

	protected String content = null;

	protected String sendtime = null;


	// 新增或修改时执行表单验证
	public void validate() {
		// 清除错误消息
		clearErrorsAndMessages();

		// 取得请求参数
		String queryString = getRequestPath();
		if (queryString.indexOf("noticeadd!insert") != -1
				|| queryString.indexOf("noticeedit!update") != -1) {
			// 检查表单字段title
			if (title == null || title.equals("")) {
				addFieldError("title",getText("notice.error.title"));
			}

			// 检查表单字段content
			if (content == null || content.equals("")) {
				addFieldError("content", getText("notice.error.content"));
			}
		}
	}

	// 请求noticeInit.do的处理函数
	public String init() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// 重设分页参数
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;

		// 取得当前分页数据
		super.pager = this.getNoticeService().list(super.pageSize, super.pageNo);

		// 保存分页数据
		setSession(Constants.PAGER_NOTICE, super.pager);

		return Constants.LIST_KEY;
	}

	// 请求noticeList.do的处理函数
	public String list() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// 取得当前分页数据
		super.pager = this.getNoticeService().list(super.pageSize, super.pageNo);

		// 保存分页数据
		setSession(Constants.PAGER_NOTICE, super.pager);

		return Constants.LIST_KEY;
	}

	// 请求noticeAdd.do的处理函数
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
		setTitle(null);
		setContent(null);
		setSendtime(null);
	}

	// 给表单字段赋值
	private void bean2Form(Notice notice) {
		setId(notice.getId().toString());
		setSender(notice.getSender());
		setTitle(notice.getTitle());
		setContent(notice.getContent());
		setSendtime(notice.getSendtime());
	}

	// 请求noticeEdit.do的处理函数
	public String edit() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// id为空时返回错误
		if (this.getId() == null) {
			saveActionError("notice.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// 查询数据表
			Notice notice = this.getNoticeService().select(Integer.valueOf(id));

			// 不存在时返回错误
			if (notice == null) {
				saveActionError("notice.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// 给表单字段赋值
				bean2Form(notice);
				return Constants.EDIT_KEY;
			}
		}
	}

	// 请求noticeInsert.do的处理函数
	public String insert() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();
		
		// 插入数据表
		Notice notice = new Notice();
		notice.setSender(super.getLoginUsername());
		notice.setTitle(this.getTitle());
		notice.setContent(this.getContent());
		notice.setSendtime(this.getSendtime());
		this.getNoticeService().insert(notice);
		
		// 取得缓存的分页参数
		Pager pagerSession = (Pager) getSession(Constants.PAGER_NOTICE);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		// 查询当前页的数据
		super.pager = this.getNoticeService().list(super.pageSize, super.pageNo);
		
		// 保存成功信息
		saveActionMessage("notice.message.add.success");
		return Constants.LIST_KEY;
	}

	// 请求noticeUpdate.do的处理函数
	public String update() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// 更新数据表
		Notice notice = new Notice();
		notice.setId(new Integer(id));
		notice.setSender(super.getLoginUsername());
		notice.setTitle(this.getTitle());
		notice.setContent(this.getContent());
		notice.setSendtime(this.getSendtime());
		this.getNoticeService().update(notice);

		// 给表单字段赋值
		bean2Form(notice);
		
		// 取得缓存的分页参数
		Pager pagerSession = (Pager) getSession(Constants.PAGER_NOTICE);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		// 查询当前页的数据
		super.pager = this.getNoticeService().list(super.pageSize, super.pageNo);

		saveActionMessage("notice.message.edit.success");
		return Constants.LIST_KEY;

	}

	// 请求noticeDelete.do的处理函数
	public String delete() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// id为空时返回错误
		if (this.getId() == null) {
			saveActionError("notice.message.edit.notexist");
		} else {
			// 删除数据
			this.getNoticeService().delete(Integer.valueOf(id));
			saveActionMessage("notice.message.delete.success");
		}
		// 取得当前页的数据
		super.pager = this.getNoticeService().list(super.pageSize, super.pageNo);

		return Constants.LIST_KEY;
	}

	public NoticeService getNoticeService() {
		return noticeService;
	}

	public void setNoticeService(NoticeService noticeService) {
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
