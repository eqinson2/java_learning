package com.demo.hibernate.dao;

import com.demo.hibernate.beans.Notice;
import com.demo.hibernate.util.Pager;

public interface NoticeDAO {

	public Pager list(int pageSize, int pageNo);

	public Notice select(Integer id);

	public Integer insert(Notice record);

	public boolean update(Notice record);

	public boolean delete(Notice record);
}
