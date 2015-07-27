package com.demo.ibatis.service;

import java.util.Iterator;

import com.demo.ibatis.beans.Schedule;
import com.demo.ibatis.dao.ScheduleDAOImpl;
import com.demo.ibatis.service.ScheduleServiceImpl;
import com.demo.ibatis.util.Pager;
import com.demo.ibatis.util.SqlMapClientFactory;

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
		ScheduleDAOImpl scheduleDAO = new ScheduleDAOImpl();
		scheduleDAO.setSqlMapClient(SqlMapClientFactory.getSqlMapClient());
		scheduleService.setScheduleDAO(scheduleDAO);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	// 测试分页
	public void testList() throws Exception {
		Pager pager = scheduleService.list("admin", 25, 1);
		assertTrue(pager.getRowCount() > 0);
		Iterator<?> it = pager.getResultList().iterator();
		while (it.hasNext()) {
			Schedule schedule = (Schedule) it.next();
			assertNotNull(schedule);
		}
	}

	// 测试新增
	public void testInsert() throws Exception {
		Schedule schedule = new Schedule();
		schedule.setUsername("admin");
		schedule.setYear(new Integer(2007));
		schedule.setMonth(new Integer(8));
		schedule.setDay(new Integer(30));
		schedule.setPlan("JavaWeb");
		id = scheduleService.insert(schedule);
		assertNotNull(id);
	}
	
	// 测试查询
	public void testSelect() throws Exception {
		assertNotNull(scheduleService.select(id));
	}
	
	// 测试更新
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
		assertTrue(schedule2.getMonth().intValue()==6);
	}
	
	// 测试删除
	public void testDelete() throws Exception {
		scheduleService.delete(id);
		assertNull(scheduleService.select(id));
	}
}
