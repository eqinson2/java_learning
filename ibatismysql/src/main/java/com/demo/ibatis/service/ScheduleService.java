package com.demo.ibatis.service;

import com.demo.ibatis.beans.Schedule;
import com.demo.ibatis.util.Pager;

public interface ScheduleService {
	public Pager list(String username, int pageSize, int pageNo);

	public Schedule select(Integer id);

	public Integer insert(Schedule record);

	public boolean update(Schedule record);

	public boolean delete(Integer id);
}
