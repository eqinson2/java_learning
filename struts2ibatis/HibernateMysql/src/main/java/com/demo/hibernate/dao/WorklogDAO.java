package com.demo.hibernate.dao;

import com.demo.hibernate.beans.Worklog;
import com.demo.hibernate.util.Pager;

public interface WorklogDAO {

	public Pager list(String username, int pageSize, int pageNo);

	public Worklog select(Integer id);

	public Integer insert(Worklog record);

	public boolean update(Worklog record);

	public boolean delete(Worklog record);
}
