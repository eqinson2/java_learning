package com.demo.hibernate.service;

import com.demo.hibernate.beans.Notice;
import com.demo.hibernate.util.Pager;

public interface NoticeService {
	public Pager list(int pageSize, int pageNo);

	public Notice select(Integer id);

	public Integer insert(Notice record);

	public boolean update(Notice record);

	public boolean delete(Integer id);
}
