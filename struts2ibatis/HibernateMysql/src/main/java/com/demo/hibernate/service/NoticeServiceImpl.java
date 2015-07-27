package com.demo.hibernate.service;

import com.demo.hibernate.beans.Notice;
import com.demo.hibernate.dao.NoticeDAO;
import com.demo.hibernate.util.Pager;

public class NoticeServiceImpl implements NoticeService {

	NoticeDAO noticeDAO;

	public Pager list(int pageSize, int pageNo) {
		return noticeDAO.list(pageSize, pageNo);
	}

	public Notice select(Integer id) {
		return noticeDAO.select(id);
	}

	public Integer insert(Notice record) {
		return noticeDAO.insert(record);
	}

	public boolean update(Notice record) {
		return noticeDAO.update(record);
	}

	public boolean delete(Integer id) {
		Notice record = noticeDAO.select(id);
		return noticeDAO.delete(record);
	}

	public NoticeDAO getNoticeDAO() {
		return noticeDAO;
	}

	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

}
