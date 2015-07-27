package com.demo.hibernate.dao;

import com.demo.hibernate.beans.Meeting;
import com.demo.hibernate.util.Pager;

public interface MeetingDAO {

	public Pager list(int pageSize, int pageNo);

	public Meeting select(Integer id);

	public Integer insert(Meeting record);

	public boolean update(Meeting record);

	public boolean delete(Meeting record);
}
