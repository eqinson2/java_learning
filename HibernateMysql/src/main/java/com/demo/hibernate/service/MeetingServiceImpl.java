package com.demo.hibernate.service;

import com.demo.hibernate.beans.Meeting;
import com.demo.hibernate.dao.MeetingDAO;
import com.demo.hibernate.util.Pager;

public class MeetingServiceImpl implements MeetingService {

	MeetingDAO meetingDAO;

	public Pager list(int pageSize, int pageNo) {
		return meetingDAO.list(pageSize, pageNo);
	}

	public Meeting select(Integer id) {
		return meetingDAO.select(id);
	}

	public Integer insert(Meeting record) {
		return meetingDAO.insert(record);
	}

	public boolean update(Meeting record) {
		return meetingDAO.update(record);
	}

	public boolean delete(Integer id) {
		Meeting record = meetingDAO.select(id);
		return meetingDAO.delete(record);
	}

	public MeetingDAO getMeetingDAO() {
		return meetingDAO;
	}

	public void setMeetingDAO(MeetingDAO meetingDAO) {
		this.meetingDAO = meetingDAO;
	}

}
