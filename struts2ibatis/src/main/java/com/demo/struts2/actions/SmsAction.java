package com.demo.struts2.actions;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.demo.ibatis.beans.Sms;
import com.demo.ibatis.dao.SmsDAOImpl;
import com.demo.ibatis.service.SmsService;
import com.demo.ibatis.service.SmsServiceImpl;
import com.demo.ibatis.util.Pager;
import com.demo.ibatis.util.SqlMapClientFactory;
import com.demo.struts2.common.PageAction;
import com.demo.struts2.util.Constants;

public class SmsAction extends PageAction {

	private static final long serialVersionUID = 1L;

	private SmsServiceImpl smsService;
	
	public SmsAction() {
	    super();
	    if (smsService == null) {
	        smsService = new SmsServiceImpl();
	        SmsDAOImpl smsDAO = new SmsDAOImpl();
	        smsDAO.setSqlMapClient(SqlMapClientFactory.getSqlMapClient());
	        smsService.setSmsDAO(smsDAO);
	    }
	}


	protected String id = null;

	protected String username = null;

	protected String sender = null;

	protected String message = null;

	protected String sendtime = null;

	protected String isread = null;

	public void validate() {
		clearErrorsAndMessages();

		String queryString = getRequestPath();
		if (queryString.indexOf("smsadd!insert") != -1
				|| queryString.indexOf("smsedit!update") != -1) {
			if (username == null || username.equals("")) {
				addFieldError("username",getText("sms.error.username"));
			}

			if (message == null || message.equals("")) {
				addFieldError("message", getText("sms.error.message"));
			}
		}
	}

	public String init() throws Exception {
		clearErrorsAndMessages();

		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;

		super.pager = this.getSmsService().list(super.getLoginUsername(), super.pageSize, super.pageNo);

		setSession(Constants.PAGER_SMS, super.pager);

		return Constants.LIST_KEY;
	}

	public String list() throws Exception {
		clearErrorsAndMessages();

		super.pager = this.getSmsService().list(super.getLoginUsername(), super.pageSize, super.pageNo);

		setSession(Constants.PAGER_SMS, super.pager);

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
		setSender(null);
		setMessage(null);
		setSendtime(null);
		setIsread(null);
	}

	public String insert() throws Exception {
		clearErrorsAndMessages();
		
		Sms sms = new Sms();
		sms.setUsername(this.getUsername());
		sms.setSender(super.getLoginUsername());
		sms.setMessage(this.getMessage());
		sms.setSendtime(this.getSendtime());
		sms.setIsread("0");
		this.getSmsService().insert(sms);		
		
		Pager pagerSession = (Pager) getSession(Constants.PAGER_SMS);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		super.pager = this.getSmsService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		saveActionMessage("sms.message.add.success");
		return Constants.LIST_KEY;
	}

	public String read() throws Exception {
		clearErrorsAndMessages();

		if (this.getId() == null) {
			saveActionError("sms.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			Sms sms = this.getSmsService().select(Integer.valueOf(id));

			if (sms == null) {
				saveActionError("sms.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				sms.setIsread("1");
				this.getSmsService().update(sms);
				
				Pager pagerSession = (Pager) getSession(Constants.PAGER_SMS);
				super.pageSize = pagerSession.getPageSize();
				super.pageNo = pagerSession.getPageNo();

				super.pager = this.getSmsService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
				
				return Constants.LIST_KEY;
			}
		}
	}	

	public String delete() throws Exception {
		clearErrorsAndMessages();

		if (this.getId() == null) {
			saveActionError("sms.message.edit.notexist");
		} else {
			this.getSmsService().delete(Integer.valueOf(id));
			saveActionMessage("sms.message.delete.success");
		}
		super.pager = this.getSmsService().list(super.getLoginUsername(), super.pageSize, super.pageNo);

		return Constants.LIST_KEY;
	}

	public SmsService getSmsService() {
		return smsService;
	}

	public void setSmsService(SmsServiceImpl smsService) {
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
