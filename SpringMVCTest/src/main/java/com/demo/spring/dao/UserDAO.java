package com.demo.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDAO {
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public boolean isValid(String username, String password) {
		List userList = new ArrayList();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(
				"SELECT * FROM user WHERE username='" + username + "' and password='" + password + "'",
				new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						User user = new User();
						user.setId(rs.getString("ID"));
						user.setUsername(rs.getString("username"));
						user.setPassword(rs.getString("password"));
						user.setEmail(rs.getString("email"));
						return user;
					}
				});
		if (userList.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isExist(String username) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int count = jdbcTemplate.queryForInt("SELECT count(*) FROM user WHERE username='" + username + "'");
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void insertUser(User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		String email = user.getEmail();
		JdbcTemplate jt = new JdbcTemplate(getDataSource());
		jt.update("insert into user(username,password,email) values ('" + username + "','" + password + "','" + email
				+ "');");
	}
}
