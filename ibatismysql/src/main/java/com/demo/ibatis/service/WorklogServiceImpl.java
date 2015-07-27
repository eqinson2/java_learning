package com.demo.ibatis.service;

import java.util.ArrayList;
import java.util.List;

import com.demo.ibatis.beans.Worklog;
import com.demo.ibatis.beans.WorklogExample;
import com.demo.ibatis.beans.WorklogExample.Criteria;
import com.demo.ibatis.dao.WorklogDAO;
import com.demo.ibatis.util.Pager;

public class WorklogServiceImpl implements WorklogService {

	WorklogDAO worklogDAO;

	public Pager list(String username, int pageSize, int pageNo) {
		try {
			int rowCount = worklogDAO.countByExample(new WorklogExample());

			int startIndex = pageSize * (pageNo - 1);

			WorklogExample example = new WorklogExample();
			Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(username);
			example.setOrderByClause("year desc,month desc,day desc");
			example.setLimitClauseStart(String.valueOf(startIndex));
			example.setLimitClauseCount(String.valueOf(pageSize));
			List<?> result = worklogDAO.selectByExampleWithBLOBs(example);

			return new Pager(pageSize, pageNo, rowCount, result);
		} catch (Exception e) {
			e.printStackTrace();
			return new Pager(pageSize, pageNo, 0, new ArrayList<Object>());
		}
	}

	public Worklog select(Integer id) {
		try {
			return worklogDAO.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Integer insert(Worklog record) {
		try {
			return worklogDAO.insert(record);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean update(Worklog record) {
		try {
			worklogDAO.updateByPrimaryKeyWithBLOBs(record);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Integer id) {
		try {
			worklogDAO.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public WorklogDAO getWorklogDAO() {
		return worklogDAO;
	}

	public void setWorklogDAO(WorklogDAO worklogDAO) {
		this.worklogDAO = worklogDAO;
	}

}
