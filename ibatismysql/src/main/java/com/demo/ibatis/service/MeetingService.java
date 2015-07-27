package com.demo.ibatis.service;

import com.demo.ibatis.beans.Meeting;
import com.demo.ibatis.util.Pager;

public interface MeetingService {
	public Pager list(int pageSize, int pageNo);

	public Meeting select(Integer id);

	public Integer insert(Meeting record);

	public boolean update(Meeting record);

	public boolean delete(Integer id);
}
