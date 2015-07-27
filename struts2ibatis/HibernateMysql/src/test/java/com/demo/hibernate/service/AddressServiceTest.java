package com.demo.hibernate.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.demo.hibernate.beans.Address;
import com.demo.hibernate.dao.AddressDAO;
import com.demo.hibernate.dao.AddressDAOImpl;
import com.demo.hibernate.service.AddressServiceImpl;
import com.demo.hibernate.util.Pager;

public class AddressServiceTest {

	public AddressServiceImpl addressService;
	public static Integer id = null;

	public AddressServiceTest() {
	}

	@Before
	public void setUp() throws Exception {
		addressService = new AddressServiceImpl();
		AddressDAO addressDAO = new AddressDAOImpl();
		addressService.setAddressDAO(addressDAO);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testList() throws Exception {
		Pager pager = addressService.list("admin", 25, 1);
		assertTrue(pager.getRowCount() > 0);
		Iterator<?> it = pager.getResultList().iterator();
		while (it.hasNext()) {
			Address address = (Address) it.next();
			assertNotNull(address);
		}
	}

	@Test
	public void testInsert() throws Exception {
		Address address = new Address();
		address.setUsername("admin");
		address.setName("andy");
		address.setSex("2");
		address.setMobile("13888886666");
		address.setEmail("andy@163.com");
		address.setQq("12345678");
		address.setCompany("Intel");
		address.setAddress("×ÏÖñ");
		address.setPostcode("200089");
		id = addressService.insert(address);
		assertNotNull(id);
	}

	@Test
	public void testUpdate() throws Exception {
		Address address = new Address();
		address.setId(id);
		address.setUsername("admin");
		address.setName("andy");
		address.setSex("2");
		address.setMobile("13888886666");
		address.setEmail("andy@163.com");
		address.setQq("12345678");
		address.setCompany("Microsoft");
		address.setAddress("Ğì¼Ò»ã");
		address.setPostcode("200089");
		addressService.update(address);

		Address address2 = addressService.select(id);
		assertTrue(address2.getCompany().equals("Microsoft"));
	}

	@Test
	public void testDelete() throws Exception {
		addressService.delete(id);
		assertNull(addressService.select(id));
	}
}
