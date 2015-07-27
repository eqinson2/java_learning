package com.demo.ibatis.service;

import java.util.ArrayList;
import java.util.List;

import com.demo.ibatis.beans.MeetingExample;
import com.demo.ibatis.beans.Meeting;
import com.demo.ibatis.dao.MeetingDAO;
import com.demo.ibatis.util.Pager;

public class MeetingServiceImpl implements MeetingService {

	MeetingDAO meetingDAO;

	public Pager list(int pageSize, int pageNo) {
		try {
			int rowCount = meetingDAO.countByExample(new MeetingExample());

			int startIndex = pageSize * (pageNo - 1);

			MeetingExample example = new MeetingExample();
			example.setOrderByClause("starttime desc,endtime desc");
			example.setLimitClauseStart(String.valueOf(startIndex));
			example.setLimitClauseCount(String.valueOf(pageSize));
			List<?> result = meetingDAO.selectByExampleWithBLOBs(example);

			return new Pager(pageSize, pageNo, rowCount, result);
		} catch (Exception e) {
			e.printStackTrace();
			return new Pager(pageSize, pageNo, 0, new ArrayList<Object>());
		}
	}

	public Meeting select(Integer id) {
		try {
			return meetingDAO.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Integer insert(Meeting record) {
		try {
			return meetingDAO.insert(record);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean update(Meeting record) {
		try {
			meetingDAO.updateByPrimaryKeyWithBLOBs(record);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Integer id) {
		try {
			meetingDAO.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public MeetingDAO getMeetingDAO() {
		return meetingDAO;
	}

	public void setMeetingDAO(MeetingDAO meetingDAO) {
		this.meetingDAO = meetingDAO;
	}

}
