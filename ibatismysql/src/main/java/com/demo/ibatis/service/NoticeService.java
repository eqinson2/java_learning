package com.demo.ibatis.service;

import com.demo.ibatis.beans.Notice;
import com.demo.ibatis.util.Pager;

public interface NoticeService {
	public Pager list(int pageSize, int pageNo);

	public Notice select(Integer id);

	public Integer insert(Notice record);

	public boolean update(Notice record);

	public boolean delete(Integer id);
}
