package com.demo.ibatis.service;

import java.util.Iterator;

import com.demo.ibatis.beans.Meeting;
import com.demo.ibatis.dao.MeetingDAOImpl;
import com.demo.ibatis.service.MeetingServiceImpl;
import com.demo.ibatis.util.Pager;
import com.demo.ibatis.util.SqlMapClientFactory;

import junit.framework.TestCase;

public class MeetingServiceTest extends TestCase {

	public MeetingServiceImpl meetingService;
	public static Integer id = null;

	public MeetingServiceTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		meetingService = new MeetingServiceImpl();
		MeetingDAOImpl meetingDAO = new MeetingDAOImpl();
		meetingDAO.setSqlMapClient(SqlMapClientFactory.getSqlMapClient());
		meetingService.setMeetingDAO(meetingDAO);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	// 测试分页
	public void testList() throws Exception {
		Pager pager = meetingService.list(25, 1);
		assertTrue(pager.getRowCount() > 0);
		Iterator<?> it = pager.getResultList().iterator();
		while (it.hasNext()) {
			Meeting meeting = (Meeting) it.next();
			assertNotNull(meeting);
		}
	}

	// 测试新增
	public void testInsert() throws Exception {
		Meeting meeting = new Meeting();
		meeting.setSender("admin");
		meeting.setStarttime("2008-10-10");
		meeting.setEndtime("2008-10-12");
		meeting.setAddress("Beijing");
		meeting.setTitle("JavaWeb");
		meeting.setContent("JavaWeb");
		id = meetingService.insert(meeting);
		assertNotNull(id);
	}
	
	// 测试查询
	public void testSelect() throws Exception {
		assertNotNull(meetingService.select(id));
	}
	
	// 测试更新
	public void testUpdate() throws Exception {
		Meeting meeting = new Meeting();
		meeting.setId(id);
		meeting.setSender("admin");
		meeting.setStarttime("2008-10-10");
		meeting.setEndtime("2008-10-12");
		meeting.setAddress("Shanghai");
		meeting.setTitle("JavaWeb");
		meeting.setContent("JavaWeb");
		meetingService.update(meeting);

		Meeting meeting2 = meetingService.select(id);
		assertTrue(meeting2.getAddress().equals("Shanghai"));
	}
	
	// 测试删除
	public void testDelete() throws Exception {
		meetingService.delete(id);
		assertNull(meetingService.select(id));
	}
}
