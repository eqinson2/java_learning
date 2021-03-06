package com.demo.ibatis.dao;

import com.demo.ibatis.beans.Schedule;
import com.demo.ibatis.beans.ScheduleExample;
import com.ibatis.sqlmap.client.SqlMapClient;
import java.sql.SQLException;
import java.util.List;

public class ScheduleDAOImpl implements ScheduleDAO {

	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to
	 * the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	private SqlMapClient sqlMapClient;

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public ScheduleDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public Integer insert(Schedule record) throws SQLException {
		Object newKey = sqlMapClient.insert("schedule.abatorgenerated_insert", record);
		return (Integer) newKey;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public int updateByPrimaryKeyWithoutBLOBs(Schedule record) throws SQLException {
		int rows = sqlMapClient.update("schedule.abatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public int updateByPrimaryKeyWithBLOBs(Schedule record) throws SQLException {
		int rows = sqlMapClient.update("schedule.abatorgenerated_updateByPrimaryKeyWithBLOBs", record);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public int updateByPrimaryKeySelective(Schedule record) throws SQLException {
		int rows = sqlMapClient.update("schedule.abatorgenerated_updateByPrimaryKeySelective", record);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	@SuppressWarnings("unchecked")
	public List<Schedule> selectByExampleWithoutBLOBs(ScheduleExample example) throws SQLException {
		List<Schedule> list = (List<Schedule>) sqlMapClient.queryForList("schedule.abatorgenerated_selectByExample",
				example);
		return list;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	@SuppressWarnings("unchecked")
	public List<Schedule> selectByExampleWithBLOBs(ScheduleExample example) throws SQLException {
		List<Schedule> list = (List<Schedule>) sqlMapClient
				.queryForList("schedule.abatorgenerated_selectByExampleWithBLOBs", example);
		return list;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public Schedule selectByPrimaryKey(Integer id) throws SQLException {
		Schedule key = new Schedule();
		key.setId(id);
		Schedule record = (Schedule) sqlMapClient.queryForObject("schedule.abatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public int deleteByExample(ScheduleExample example) throws SQLException {
		int rows = sqlMapClient.delete("schedule.abatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public int deleteByPrimaryKey(Integer id) throws SQLException {
		Schedule key = new Schedule();
		key.setId(id);
		int rows = sqlMapClient.delete("schedule.abatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public int countByExample(ScheduleExample example) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject("schedule.abatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public int updateByExampleSelective(Schedule record, ScheduleExample example) throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update("schedule.abatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public int updateByExampleWithBLOBs(Schedule record, ScheduleExample example) throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update("schedule.abatorgenerated_updateByExampleWithBLOBs", parms);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public int updateByExampleWithoutBLOBs(Schedule record, ScheduleExample example) throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update("schedule.abatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This class was generated by Abator for iBATIS. This class corresponds to
	 * the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	private static class UpdateByExampleParms extends ScheduleExample {
		private Object record;

		public UpdateByExampleParms(Object record, ScheduleExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}