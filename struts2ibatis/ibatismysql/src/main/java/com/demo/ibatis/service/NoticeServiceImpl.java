package com.demo.ibatis.service;

import java.util.ArrayList;
import java.util.List;

import com.demo.ibatis.beans.Notice;
import com.demo.ibatis.beans.NoticeExample;
import com.demo.ibatis.dao.NoticeDAO;
import com.demo.ibatis.util.Pager;

public class NoticeServiceImpl implements NoticeService {

	NoticeDAO noticeDAO;

	public Pager list(int pageSize, int pageNo) {
		try {
			int rowCount = noticeDAO.countByExample(new NoticeExample());

			int startIndex = pageSize * (pageNo - 1);

			NoticeExample example = new NoticeExample();
			example.setOrderByClause("sendtime desc");
			example.setLimitClauseStart(String.valueOf(startIndex));
			example.setLimitClauseCount(String.valueOf(pageSize));
			List<?> result = noticeDAO.selectByExampleWithBLOBs(example);

			return new Pager(pageSize, pageNo, rowCount, result);
		} catch (Exception e) {
			e.printStackTrace();
			return new Pager(pageSize, pageNo, 0, new ArrayList<Object>());
		}
	}

	public Notice select(Integer id) {
		try {
			return noticeDAO.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Integer insert(Notice record) {
		try {
			return noticeDAO.insert(record);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean update(Notice record) {
		try {
			noticeDAO.updateByPrimaryKeyWithBLOBs(record);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Integer id) {
		try {
			noticeDAO.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public NoticeDAO getNoticeDAO() {
		return noticeDAO;
	}

	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

}
