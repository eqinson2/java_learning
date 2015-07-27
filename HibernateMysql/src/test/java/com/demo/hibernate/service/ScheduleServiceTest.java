package com.demo.hibernate.service;

import java.util.Iterator;

import com.demo.hibernate.beans.Schedule;
import com.demo.hibernate.dao.ScheduleDAO;
import com.demo.hibernate.dao.ScheduleDAOImpl;
import com.demo.hibernate.service.ScheduleServiceImpl;
import com.demo.hibernate.util.Pager;

import junit.framework.TestCase;

public class ScheduleServiceTest extends TestCase {

	public ScheduleServiceImpl scheduleService;
	public static Integer id = null;

	public ScheduleServiceTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		scheduleService = new ScheduleServiceImpl();
		ScheduleDAO scheduleDAO = new ScheduleDAOImpl();
		scheduleService.setScheduleDAO(scheduleDAO);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testInsert() throws Exception {
		Schedule schedule = new Schedule();
		schedule.setUsername("eqinson888");
		schedule.setYear(new Integer(2007));
		schedule.setMonth(new Integer(8));
		schedule.setDay(new Integer(30));
		schedule.setPlan("JavaWeb");
		id = scheduleService.insert(schedule);
		assertNotNull(id);
	}

	public void testList() throws Exception {
		Pager pager = scheduleService.list("eqinson888", 25, 1);
		assertTrue(pager.getRowCount() > 0);
		Iterator<?> it = pager.getResultList().iterator();
		while (it.hasNext()) {
			Schedule schedule = (Schedule) it.next();
			assertNotNull(schedule);
		}
	}

	public void testSelect() throws Exception {
		assertNotNull(scheduleService.select(id));
	}

	public void testUpdate() throws Exception {
		Schedule schedule = new Schedule();
		schedule.setId(id);
		schedule.setUsername("admin");
		schedule.setYear(new Integer(2007));
		schedule.setMonth(new Integer(6));
		schedule.setDay(new Integer(30));
		schedule.setPlan("JavaWeb");
		scheduleService.update(schedule);

		Schedule schedule2 = scheduleService.select(id);
		assertTrue(schedule2.getMonth().intValue() == 6);
	}

	public void testDelete() throws Exception {
		scheduleService.delete(id);
		assertNull(scheduleService.select(id));
	}
}
