package com.demo.hibernate.service;

import com.demo.hibernate.beans.Address;
import com.demo.hibernate.util.Pager;

public interface AddressService {
	public Pager list(String username, int pageSize, int pageNo);

	public Address select(Integer id);

	public Integer insert(Address record);

	public boolean update(Address record);

	public boolean delete(Integer id);
}
