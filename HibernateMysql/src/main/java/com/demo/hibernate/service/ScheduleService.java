package com.demo.hibernate.service;

import com.demo.hibernate.beans.Schedule;
import com.demo.hibernate.util.Pager;

public interface ScheduleService {
	public Pager list(String username, int pageSize, int pageNo);

	public Schedule select(Integer id);

	public Integer insert(Schedule record);

	public boolean update(Schedule record);

	public boolean delete(Integer id);
}
