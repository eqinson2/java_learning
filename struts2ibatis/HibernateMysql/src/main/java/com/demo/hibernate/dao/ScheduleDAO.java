package com.demo.hibernate.dao;

import com.demo.hibernate.beans.Schedule;
import com.demo.hibernate.util.Pager;

public interface ScheduleDAO {

	public Pager list(String username, int pageSize, int pageNo);

	public Schedule select(Integer id);

	public Integer insert(Schedule record);

	public boolean update(Schedule record);

	public boolean delete(Schedule record);
}
