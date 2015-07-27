package com.demo.hibernate.dao;

import com.demo.hibernate.beans.Sms;
import com.demo.hibernate.util.Pager;

public interface SmsDAO {

	public Pager list(String username, int pageSize, int pageNo);

	public Sms select(Integer id);

	public Integer insert(Sms record);

	public boolean update(Sms record);

	public boolean delete(Sms record);
}
