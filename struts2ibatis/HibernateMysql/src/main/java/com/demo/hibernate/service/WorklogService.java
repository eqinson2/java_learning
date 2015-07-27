package com.demo.hibernate.service;

import com.demo.hibernate.beans.Worklog;
import com.demo.hibernate.util.Pager;

public interface WorklogService {
	public Pager list(String username, int pageSize, int pageNo);

	public Worklog select(Integer id);

	public Integer insert(Worklog record);

	public boolean update(Worklog record);

	public boolean delete(Integer id);
}
