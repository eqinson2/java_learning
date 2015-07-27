package com.demo.hibernate.service;

import java.util.Iterator;

import com.demo.hibernate.beans.Worklog;
import com.demo.hibernate.dao.WorklogDAO;
import com.demo.hibernate.dao.WorklogDAOImpl;
import com.demo.hibernate.service.WorklogServiceImpl;
import com.demo.hibernate.util.Pager;

import junit.framework.TestCase;

public class WorklogServiceTest extends TestCase {

	public WorklogServiceImpl worklogService;
	public static Integer id = null;

	public WorklogServiceTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		worklogService = new WorklogServiceImpl();
		WorklogDAO worklogDAO = new WorklogDAOImpl();
		worklogService.setWorklogDAO(worklogDAO);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testList() throws Exception {
		Pager pager = worklogService.list("admin", 25, 1);
		assertTrue(pager.getRowCount() > 0);
		Iterator<?> it = pager.getResultList().iterator();
		while (it.hasNext()) {
			Worklog worklog = (Worklog) it.next();
			assertNotNull(worklog);
		}
	}

	public void testInsert() throws Exception {
		Worklog worklog = new Worklog();
		worklog.setUsername("admin");
		worklog.setYear(new Integer(2007));
		worklog.setMonth(new Integer(8));
		worklog.setDay(new Integer(30));
		worklog.setTitle("JavaWeb");
		worklog.setDescription("JavaWeb");
		worklog.setLogtime("2008-10-10");
		id = worklogService.insert(worklog);
		assertNotNull(id);
	}

	public void testSelect() throws Exception {
		assertNotNull(worklogService.select(id));
	}

	public void testUpdate() throws Exception {
		Worklog worklog = new Worklog();
		worklog.setId(id);
		worklog.setUsername("admin");
		worklog.setYear(new Integer(2007));
		worklog.setMonth(new Integer(6));
		worklog.setDay(new Integer(30));
		worklog.setTitle("JavaWeb");
		worklog.setDescription("JavaWeb");
		worklog.setLogtime("2008-10-10");
		worklogService.update(worklog);

		Worklog worklog2 = worklogService.select(id);
		assertTrue(worklog2.getMonth().intValue() == 6);
	}

	public void testDelete() throws Exception {
		worklogService.delete(id);
		assertNull(worklogService.select(id));
	}
}
