package com.demo.hibernate.service;

import java.util.Iterator;

import com.demo.hibernate.beans.Notice;
import com.demo.hibernate.dao.NoticeDAO;
import com.demo.hibernate.dao.NoticeDAOImpl;
import com.demo.hibernate.service.NoticeServiceImpl;
import com.demo.hibernate.util.Pager;

import junit.framework.TestCase;

public class NoticeServiceTest extends TestCase {

	public NoticeServiceImpl noticeService;
	public static Integer id = null;

	public NoticeServiceTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		noticeService = new NoticeServiceImpl();
		NoticeDAO noticeDAO = new NoticeDAOImpl();
		noticeService.setNoticeDAO(noticeDAO);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testList() throws Exception {
		Pager pager = noticeService.list(25, 1);
		assertTrue(pager.getRowCount() > 0);
		Iterator<?> it = pager.getResultList().iterator();
		while (it.hasNext()) {
			Notice notice = (Notice) it.next();
			assertNotNull(notice);
		}
	}

	public void testInsert() throws Exception {
		Notice notice = new Notice();
		notice.setSender("admin");
		notice.setTitle("JavaWeb");
		notice.setContent("JavaWeb");
		notice.setSendtime("2008-10-10");
		id = noticeService.insert(notice);
		assertNotNull(id);
	}

	public void testSelect() throws Exception {
		assertNotNull(noticeService.select(id));
	}

	public void testUpdate() throws Exception {
		Notice notice = new Notice();
		notice.setId(id);
		notice.setSender("admin");
		notice.setTitle("Hibernate");
		notice.setContent("JavaWeb");
		notice.setSendtime("2008-10-10");
		noticeService.update(notice);

		Notice notice2 = noticeService.select(id);
		assertTrue(notice2.getTitle().equals("Hibernate"));
	}

	public void testDelete() throws Exception {
		noticeService.delete(id);
		assertNull(noticeService.select(id));
	}
}
