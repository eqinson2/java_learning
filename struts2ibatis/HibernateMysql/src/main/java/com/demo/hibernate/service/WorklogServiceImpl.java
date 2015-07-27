package com.demo.hibernate.service;

import com.demo.hibernate.beans.Worklog;
import com.demo.hibernate.dao.WorklogDAO;
import com.demo.hibernate.util.Pager;

public class WorklogServiceImpl implements WorklogService {

	WorklogDAO worklogDAO;

	public Pager list(String username, int pageSize, int pageNo) {
		return worklogDAO.list(username, pageSize, pageNo);
	}

	public Worklog select(Integer id) {
		return worklogDAO.select(id);
	}

	public Integer insert(Worklog record) {
		return worklogDAO.insert(record);
	}

	public boolean update(Worklog record) {
		return worklogDAO.update(record);
	}

	public boolean delete(Integer id) {
		Worklog record = worklogDAO.select(id);
		return worklogDAO.delete(record);
	}

	public WorklogDAO getWorklogDAO() {
		return worklogDAO;
	}

	public void setWorklogDAO(WorklogDAO worklogDAO) {
		this.worklogDAO = worklogDAO;
	}

}
