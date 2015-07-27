package com.demo.ibatis.dao;

import java.sql.SQLException;

import com.demo.ibatis.beans.User;
import com.ibatis.sqlmap.client.SqlMapClient;

public class UserDAO {
	private SqlMapClient sqlMapClient;

	public User getUser(String username) throws SQLException {
		User record = (User) sqlMapClient.queryForObject("user.getUser",
				username);
		return record;
	}

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
}
