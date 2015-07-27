package com.demo.hibernate.service;

import com.demo.hibernate.beans.Address;
import com.demo.hibernate.dao.AddressDAO;
import com.demo.hibernate.util.Pager;

public class AddressServiceImpl implements AddressService {

	AddressDAO addressDAO;

	public Pager list(String username, int pageSize, int pageNo) {
		return addressDAO.list(username, pageSize, pageNo);
	}

	public Address select(Integer id) {
		return addressDAO.select(id);
	}

	public Integer insert(Address record) {
		return addressDAO.insert(record);
	}

	public boolean update(Address record) {
		return addressDAO.update(record);
	}

	public boolean delete(Integer id) {
		Address record = addressDAO.select(id);
		return addressDAO.delete(record);
	}

	public AddressDAO getAddressDAO() {
		return addressDAO;
	}

	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

}
