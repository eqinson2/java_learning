package com.demo.ibatis.util;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {

	private static final SqlMapClient sqlMapClient;
	static {
		try {
			String resource = "sqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (Exception e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}
}
