package com.demo.ibatis.service;

import java.util.ArrayList;
import java.util.List;

import com.demo.ibatis.beans.Sms;
import com.demo.ibatis.beans.SmsExample;
import com.demo.ibatis.beans.SmsExample.Criteria;
import com.demo.ibatis.dao.SmsDAO;
import com.demo.ibatis.util.Pager;

public class SmsServiceImpl implements SmsService {

	SmsDAO smsDAO;

	public Pager list(String username, int pageSize, int pageNo) {
		try {
			int rowCount = smsDAO.countByExample(new SmsExample());

			int startIndex = pageSize * (pageNo - 1);

			SmsExample example = new SmsExample();
			Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(username);
			example.setOrderByClause("sendtime desc");
			example.setLimitClauseStart(String.valueOf(startIndex));
			example.setLimitClauseCount(String.valueOf(pageSize));
			List<?> result = smsDAO.selectByExampleWithBLOBs(example);

			return new Pager(pageSize, pageNo, rowCount, result);
		} catch (Exception e) {
			e.printStackTrace();
			return new Pager(pageSize, pageNo, 0, new ArrayList<Object>());
		}
	}

	public Sms select(Integer id) {
		try {
			return smsDAO.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean read(Integer id) {
		try {
			Sms record = smsDAO.selectByPrimaryKey(id);
			record.setIsread("1");
			smsDAO.updateByPrimaryKeySelective(record);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Integer insert(Sms record) {
		try {
			return smsDAO.insert(record);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean update(Sms record) {
		try {
			smsDAO.updateByPrimaryKeyWithBLOBs(record);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Integer id) {
		try {
			smsDAO.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public SmsDAO getSmsDAO() {
		return smsDAO;
	}

	public void setSmsDAO(SmsDAO smsDAO) {
		this.smsDAO = smsDAO;
	}

}
