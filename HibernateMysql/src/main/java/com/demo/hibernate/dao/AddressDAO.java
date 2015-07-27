package com.demo.hibernate.dao;

import com.demo.hibernate.beans.Address;
import com.demo.hibernate.util.Pager;

public interface AddressDAO {

	public Pager list(String username, int pageSize, int pageNo);

	public Address select(Integer id);

	public Integer insert(Address record);

	public boolean update(Address record);

	public boolean delete(Address record);
}
