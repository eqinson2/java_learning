package com.demo.ibatis.dao;

import com.demo.ibatis.beans.Address;
import com.demo.ibatis.beans.AddressExample;
import com.ibatis.sqlmap.client.SqlMapClient;
import java.sql.SQLException;
import java.util.List;

public class AddressDAOImpl implements AddressDAO {

	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to
	 * the database table address
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	private SqlMapClient sqlMapClient;

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table address
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public AddressDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table address
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table address
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table address
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public Integer insert(Address record) throws SQLException {
		Object newKey = sqlMapClient.insert("address.abatorgenerated_insert", record);
		return (Integer) newKey;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table address
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public int updateByPrimaryKey(Address record) throws SQLException {
		int rows = sqlMapClient.update("address.abatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table address
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public int updateByPrimaryKeySelective(Address record) throws SQLException {
		int rows = sqlMapClient.update("address.abatorgenerated_updateByPrimaryKeySelective", record);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table address
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	@SuppressWarnings("unchecked")
	public List<Address> selectByExample(AddressExample example) throws SQLException {
		List<Address> list = (List<Address>) sqlMapClient.queryForList("address.abatorgenerated_selectByExample",
				example);
		return list;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table address
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public Address selectByPrimaryKey(Integer id) throws SQLException {
		Address key = new Address();
		key.setId(id);
		Address record = (Address) sqlMapClient.queryForObject("address.abatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table address
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public int deleteByExample(AddressExample example) throws SQLException {
		int rows = sqlMapClient.delete("address.abatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table address
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public int deleteByPrimaryKey(Integer id) throws SQLException {
		Address key = new Address();
		key.setId(id);
		int rows = sqlMapClient.delete("address.abatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table address
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public int countByExample(AddressExample example) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject("address.abatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table address
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public int updateByExampleSelective(Address record, AddressExample example) throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update("address.abatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table address
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public int updateByExample(Address record, AddressExample example) throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update("address.abatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This class was generated by Abator for iBATIS. This class corresponds to
	 * the database table address
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	private static class UpdateByExampleParms extends AddressExample {
		private Object record;

		public UpdateByExampleParms(Object record, AddressExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}