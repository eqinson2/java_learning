package com.demo.ibatis.service;

import com.demo.ibatis.beans.Worklog;
import com.demo.ibatis.util.Pager;

public interface WorklogService {
	public Pager list(String username, int pageSize, int pageNo);

	public Worklog select(Integer id);

	public Integer insert(Worklog record);

	public boolean update(Worklog record);

	public boolean delete(Integer id);
}
