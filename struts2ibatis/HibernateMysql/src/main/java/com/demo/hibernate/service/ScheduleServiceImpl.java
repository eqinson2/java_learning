package com.demo.hibernate.service;

import com.demo.hibernate.beans.Schedule;
import com.demo.hibernate.dao.ScheduleDAO;
import com.demo.hibernate.util.Pager;

public class ScheduleServiceImpl implements ScheduleService {

	ScheduleDAO scheduleDAO;

	public Pager list(String username, int pageSize, int pageNo) {
		return scheduleDAO.list(username, pageSize, pageNo);
	}

	public Schedule select(Integer id) {
		return scheduleDAO.select(id);
	}

	public Integer insert(Schedule record) {
		return scheduleDAO.insert(record);
	}

	public boolean update(Schedule record) {
		return scheduleDAO.update(record);
	}

	public boolean delete(Integer id) {
		Schedule record = scheduleDAO.select(id);
		return scheduleDAO.delete(record);
	}

	public ScheduleDAO getScheduleDAO() {
		return scheduleDAO;
	}

	public void setScheduleDAO(ScheduleDAO scheduleDAO) {
		this.scheduleDAO = scheduleDAO;
	}

}
