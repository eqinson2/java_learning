package com.demo.ibatis.service;

import java.util.ArrayList;
import java.util.List;

import com.demo.ibatis.beans.Schedule;
import com.demo.ibatis.beans.ScheduleExample;
import com.demo.ibatis.beans.ScheduleExample.Criteria;
import com.demo.ibatis.dao.ScheduleDAO;
import com.demo.ibatis.util.Pager;

public class ScheduleServiceImpl implements ScheduleService {

	ScheduleDAO scheduleDAO;

	public Pager list(String username, int pageSize, int pageNo) {
		try {
			int rowCount = scheduleDAO.countByExample(new ScheduleExample());

			int startIndex = pageSize * (pageNo - 1);

			ScheduleExample example = new ScheduleExample();
			Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(username);
			example.setOrderByClause("year desc,month desc,day desc");
			example.setLimitClauseStart(String.valueOf(startIndex));
			example.setLimitClauseCount(String.valueOf(pageSize));
			List<?> result = scheduleDAO.selectByExampleWithBLOBs(example);

			return new Pager(pageSize, pageNo, rowCount, result);
		} catch (Exception e) {
			e.printStackTrace();
			return new Pager(pageSize, pageNo, 0, new ArrayList<Object>());
		}
	}

	public Schedule select(Integer id) {
		try {
			return scheduleDAO.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Integer insert(Schedule record) {
		try {
			return scheduleDAO.insert(record);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean update(Schedule record) {
		try {
			scheduleDAO.updateByPrimaryKeyWithBLOBs(record);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Integer id) {
		try {
			scheduleDAO.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ScheduleDAO getScheduleDAO() {
		return scheduleDAO;
	}

	public void setScheduleDAO(ScheduleDAO scheduleDAO) {
		this.scheduleDAO = scheduleDAO;
	}

}
