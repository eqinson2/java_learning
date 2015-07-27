package com.demo.hibernate.service;

import com.demo.hibernate.beans.Sms;
import com.demo.hibernate.dao.SmsDAO;
import com.demo.hibernate.util.Pager;

public class SmsServiceImpl implements SmsService {

	SmsDAO smsDAO;

	public Pager list(String username, int pageSize, int pageNo) {
		return smsDAO.list(username, pageSize, pageNo);
	}

	public Sms select(Integer id) {
		return smsDAO.select(id);
	}

	public boolean read(Integer id) {
		Sms record = smsDAO.select(id);
		record.setIsRead("1");
		return smsDAO.update(record);
	}

	public Integer insert(Sms record) {
		return smsDAO.insert(record);
	}

	public boolean update(Sms record) {
		return smsDAO.update(record);
	}

	public boolean delete(Integer id) {
		Sms record = smsDAO.select(id);
		return smsDAO.delete(record);
	}

	public SmsDAO getSmsDAO() {
		return smsDAO;
	}

	public void setSmsDAO(SmsDAO smsDAO) {
		this.smsDAO = smsDAO;
	}

}
