package com.demo.struts2.actions;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.demo.ibatis.beans.Sms;
import com.demo.ibatis.service.SmsService;
import com.demo.struts2.common.PageAction;
import com.demo.struts2.util.Constants;
import com.demo.ibatis.util.Pager;

public class SmsAction extends PageAction {

	private static final long serialVersionUID = 1L;

	private SmsService smsService;

	protected String id = null;

	protected String username = null;

	protected String sender = null;

	protected String message = null;

	protected String sendtime = null;

	protected String isread = null;

	// 新增或修改时执行表单验证
	public void validate() {
		// 清除错误消息
		clearErrorsAndMessages();

		// 取得请求参数
		String queryString = getRequestPath();
		if (queryString.indexOf("smsadd!insert") != -1
				|| queryString.indexOf("smsedit!update") != -1) {
			// 检查表单字段username
			if (username == null || username.equals("")) {
				addFieldError("username",getText("sms.error.username"));
			}

			// 检查表单字段message
			if (message == null || message.equals("")) {
				addFieldError("message", getText("sms.error.message"));
			}
		}
	}

	// 请求smsInit.do的处理函数
	public String init() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// 重设分页参数
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;

		// 取得当前分页数据
		super.pager = this.getSmsService().list(super.getLoginUsername(), super.pageSize, super.pageNo);

		// 保存分页数据
		setSession(Constants.PAGER_SMS, super.pager);

		return Constants.LIST_KEY;
	}

	// 请求smsList.do的处理函数
	public String list() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// 取得当前分页数据
		super.pager = this.getSmsService().list(super.getLoginUsername(), super.pageSize, super.pageNo);

		// 保存分页数据
		setSession(Constants.PAGER_SMS, super.pager);

		return Constants.LIST_KEY;
	}

	// 请求smsAdd.do的处理函数
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
		setSender(null);
		setMessage(null);
		setSendtime(null);
		setIsread(null);
	}

	// 请求smsInsert.do的处理函数
	public String insert() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();
		
		// 插入数据表
		Sms sms = new Sms();
		sms.setUsername(this.getUsername());
		sms.setSender(super.getLoginUsername());
		sms.setMessage(this.getMessage());
		sms.setSendtime(this.getSendtime());
		sms.setIsread("0");
		this.getSmsService().insert(sms);		
		
		// 取得缓存的分页参数
		Pager pagerSession = (Pager) getSession(Constants.PAGER_SMS);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		// 查询当前页的数据
		super.pager = this.getSmsService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// 保存成功信息
		saveActionMessage("sms.message.add.success");
		return Constants.LIST_KEY;
	}

	// 请求smsRead.do的处理函数
	public String read() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// id为空时返回错误
		if (this.getId() == null) {
			saveActionError("sms.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// 查询数据表
			Sms sms = this.getSmsService().select(Integer.valueOf(id));

			// 不存在时返回错误
			if (sms == null) {
				saveActionError("sms.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// 给表单字段赋值
				sms.setIsread("1");
				this.getSmsService().update(sms);
				
				// 取得缓存的分页参数
				Pager pagerSession = (Pager) getSession(Constants.PAGER_SMS);
				super.pageSize = pagerSession.getPageSize();
				super.pageNo = pagerSession.getPageNo();

				// 查询当前页的数据
				super.pager = this.getSmsService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
				
				return Constants.LIST_KEY;
			}
		}
	}	

	// 请求smsDelete.do的处理函数
	public String delete() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// id为空时返回错误
		if (this.getId() == null) {
			saveActionError("sms.message.edit.notexist");
		} else {
			// 删除数据
			this.getSmsService().delete(Integer.valueOf(id));
			saveActionMessage("sms.message.delete.success");
		}
		// 取得当前页的数据
		super.pager = this.getSmsService().list(super.getLoginUsername(), super.pageSize, super.pageNo);

		return Constants.LIST_KEY;
	}

	public SmsService getSmsService() {
		return smsService;
	}

	public void setSmsService(SmsService smsService) {
		this.smsService = smsService;
	}

	public String getSendtime() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");			
		sendtime = f.format(new Date());
		return sendtime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIsread() {
		return isread;
	}

	public void setIsread(String isread) {
		this.isread = isread;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
