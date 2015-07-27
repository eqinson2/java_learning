package com.demo.ibatis.service;

import com.demo.ibatis.beans.Sms;
import com.demo.ibatis.util.Pager;

public interface SmsService {
	public Pager list(String username, int pageSize, int pageNo);

	public Sms select(Integer id);

	public boolean read(Integer id);

	public Integer insert(Sms record);

	public boolean update(Sms record);

	public boolean delete(Integer id);
}
