package com.demo.hibernate.service;

import com.demo.hibernate.beans.Sms;
import com.demo.hibernate.util.Pager;

public interface SmsService {
	public Pager list(String username, int pageSize, int pageNo);

	public Sms select(Integer id);

	public boolean read(Integer id);

	public Integer insert(Sms record);

	public boolean update(Sms record);

	public boolean delete(Integer id);
}
