package com.demo.ibatis.service;

import java.util.ArrayList;
import java.util.List;

import com.demo.ibatis.beans.Address;
import com.demo.ibatis.beans.AddressExample;
import com.demo.ibatis.beans.AddressExample.Criteria;
import com.demo.ibatis.dao.AddressDAO;
import com.demo.ibatis.util.Pager;

public class AddressServiceImpl implements AddressService {

	AddressDAO addressDAO;

	public Pager list(String username, int pageSize, int pageNo) {
		try {
			int rowCount = addressDAO.countByExample(new AddressExample());

			int startIndex = pageSize * (pageNo - 1);

			AddressExample example = new AddressExample();
			Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(username);
			example.setOrderByClause("username asc");
			example.setLimitClauseStart(String.valueOf(startIndex));
			example.setLimitClauseCount(String.valueOf(pageSize));
			List<?> result = addressDAO.selectByExample(example);

			return new Pager(pageSize, pageNo, rowCount, result);
		} catch (Exception e) {
			e.printStackTrace();
			return new Pager(pageSize, pageNo, 0, new ArrayList<Object>());
		}
	}

	public Address select(Integer id) {
		try {
			return addressDAO.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Integer insert(Address record) {
		try {
			return addressDAO.insert(record);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean update(Address record) {
		try {
			addressDAO.updateByPrimaryKey(record);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Integer id) {
		try {
			addressDAO.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public AddressDAO getAddressDAO() {
		return addressDAO;
	}

	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

}
