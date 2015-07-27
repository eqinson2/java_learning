package com.demo.hibernate.service;

import java.util.Iterator;

import com.demo.hibernate.beans.Meeting;
import com.demo.hibernate.dao.MeetingDAO;
import com.demo.hibernate.dao.MeetingDAOImpl;
import com.demo.hibernate.service.MeetingServiceImpl;
import com.demo.hibernate.util.Pager;

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
		MeetingDAO meetingDAO = new MeetingDAOImpl();
		meetingService.setMeetingDAO(meetingDAO);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testList() throws Exception {
		Pager pager = meetingService.list(25, 1);
		assertTrue(pager.getRowCount() > 0);
		Iterator<?> it = pager.getResultList().iterator();
		while (it.hasNext()) {
			Meeting meeting = (Meeting) it.next();
			assertNotNull(meeting);
		}
	}

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

	public void testSelect() throws Exception {
		assertNotNull(meetingService.select(id));
	}

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

	public void testDelete() throws Exception {
		meetingService.delete(id);
		assertNull(meetingService.select(id));
	}
}
