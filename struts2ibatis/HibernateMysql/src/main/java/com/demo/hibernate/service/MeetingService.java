package com.demo.hibernate.service;

import com.demo.hibernate.beans.Meeting;
import com.demo.hibernate.util.Pager;

public interface MeetingService {
	public Pager list(int pageSize, int pageNo);

	public Meeting select(Integer id);

	public Integer insert(Meeting record);

	public boolean update(Meeting record);

	public boolean delete(Integer id);
}
