package com.demo.ibatis.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScheduleExample {

	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to
	 * the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to
	 * the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	protected String limitClauseStart;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to
	 * the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	protected String limitClauseCount;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to
	 * the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public ScheduleExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	protected ScheduleExample(ScheduleExample example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public void setLimitClauseStart(String limitClauseStart) {
		this.limitClauseStart = limitClauseStart;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public String getLimitClauseStart() {
		return limitClauseStart;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public void setLimitClauseCount(String limitClauseCount) {
		this.limitClauseCount = limitClauseCount;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public String getLimitClauseCount() {
		return limitClauseCount;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds
	 * to the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Abator for iBATIS. This class corresponds to
	 * the database table schedule
	 * 
	 * @abatorgenerated Wed Dec 03 13:46:53 CST 2008
	 */
	public static class Criteria {
		protected List<String> criteriaWithoutValue;
		protected List<Map<String, Object>> criteriaWithSingleValue;
		protected List<Map<String, Object>> criteriaWithListValue;
		protected List<Map<String, Object>> criteriaWithBetweenValue;

		protected Criteria() {
			super();
			criteriaWithoutValue = new ArrayList<String>();
			criteriaWithSingleValue = new ArrayList<Map<String, Object>>();
			criteriaWithListValue = new ArrayList<Map<String, Object>>();
			criteriaWithBetweenValue = new ArrayList<Map<String, Object>>();
		}

		public boolean isValid() {
			return criteriaWithoutValue.size() > 0 || criteriaWithSingleValue.size() > 0
					|| criteriaWithListValue.size() > 0 || criteriaWithBetweenValue.size() > 0;
		}

		public List<String> getCriteriaWithoutValue() {
			return criteriaWithoutValue;
		}

		public List<Map<String, Object>> getCriteriaWithSingleValue() {
			return criteriaWithSingleValue;
		}

		public List<Map<String, Object>> getCriteriaWithListValue() {
			return criteriaWithListValue;
		}

		public List<Map<String, Object>> getCriteriaWithBetweenValue() {
			return criteriaWithBetweenValue;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteriaWithoutValue.add(condition);
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("condition", condition);
			map.put("value", value);
			criteriaWithSingleValue.add(map);
		}

		protected void addCriterion(String condition, List<? extends Object> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("condition", condition);
			map.put("values", values);
			criteriaWithListValue.add(map);
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			List<Object> list = new ArrayList<Object>();
			list.add(value1);
			list.add(value2);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("condition", condition);
			map.put("values", list);
			criteriaWithBetweenValue.add(map);
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return this;
		}

		public Criteria andUsernameIsNull() {
			addCriterion("username is null");
			return this;
		}

		public Criteria andUsernameIsNotNull() {
			addCriterion("username is not null");
			return this;
		}

		public Criteria andUsernameEqualTo(String value) {
			addCriterion("username =", value, "username");
			return this;
		}

		public Criteria andUsernameNotEqualTo(String value) {
			addCriterion("username <>", value, "username");
			return this;
		}

		public Criteria andUsernameGreaterThan(String value) {
			addCriterion("username >", value, "username");
			return this;
		}

		public Criteria andUsernameGreaterThanOrEqualTo(String value) {
			addCriterion("username >=", value, "username");
			return this;
		}

		public Criteria andUsernameLessThan(String value) {
			addCriterion("username <", value, "username");
			return this;
		}

		public Criteria andUsernameLessThanOrEqualTo(String value) {
			addCriterion("username <=", value, "username");
			return this;
		}

		public Criteria andUsernameLike(String value) {
			addCriterion("username like", value, "username");
			return this;
		}

		public Criteria andUsernameNotLike(String value) {
			addCriterion("username not like", value, "username");
			return this;
		}

		public Criteria andUsernameIn(List<String> values) {
			addCriterion("username in", values, "username");
			return this;
		}

		public Criteria andUsernameNotIn(List<String> values) {
			addCriterion("username not in", values, "username");
			return this;
		}

		public Criteria andUsernameBetween(String value1, String value2) {
			addCriterion("username between", value1, value2, "username");
			return this;
		}

		public Criteria andUsernameNotBetween(String value1, String value2) {
			addCriterion("username not between", value1, value2, "username");
			return this;
		}

		public Criteria andYearIsNull() {
			addCriterion("year is null");
			return this;
		}

		public Criteria andYearIsNotNull() {
			addCriterion("year is not null");
			return this;
		}

		public Criteria andYearEqualTo(Integer value) {
			addCriterion("year =", value, "year");
			return this;
		}

		public Criteria andYearNotEqualTo(Integer value) {
			addCriterion("year <>", value, "year");
			return this;
		}

		public Criteria andYearGreaterThan(Integer value) {
			addCriterion("year >", value, "year");
			return this;
		}

		public Criteria andYearGreaterThanOrEqualTo(Integer value) {
			addCriterion("year >=", value, "year");
			return this;
		}

		public Criteria andYearLessThan(Integer value) {
			addCriterion("year <", value, "year");
			return this;
		}

		public Criteria andYearLessThanOrEqualTo(Integer value) {
			addCriterion("year <=", value, "year");
			return this;
		}

		public Criteria andYearIn(List<Integer> values) {
			addCriterion("year in", values, "year");
			return this;
		}

		public Criteria andYearNotIn(List<Integer> values) {
			addCriterion("year not in", values, "year");
			return this;
		}

		public Criteria andYearBetween(Integer value1, Integer value2) {
			addCriterion("year between", value1, value2, "year");
			return this;
		}

		public Criteria andYearNotBetween(Integer value1, Integer value2) {
			addCriterion("year not between", value1, value2, "year");
			return this;
		}

		public Criteria andMonthIsNull() {
			addCriterion("month is null");
			return this;
		}

		public Criteria andMonthIsNotNull() {
			addCriterion("month is not null");
			return this;
		}

		public Criteria andMonthEqualTo(Integer value) {
			addCriterion("month =", value, "month");
			return this;
		}

		public Criteria andMonthNotEqualTo(Integer value) {
			addCriterion("month <>", value, "month");
			return this;
		}

		public Criteria andMonthGreaterThan(Integer value) {
			addCriterion("month >", value, "month");
			return this;
		}

		public Criteria andMonthGreaterThanOrEqualTo(Integer value) {
			addCriterion("month >=", value, "month");
			return this;
		}

		public Criteria andMonthLessThan(Integer value) {
			addCriterion("month <", value, "month");
			return this;
		}

		public Criteria andMonthLessThanOrEqualTo(Integer value) {
			addCriterion("month <=", value, "month");
			return this;
		}

		public Criteria andMonthIn(List<Integer> values) {
			addCriterion("month in", values, "month");
			return this;
		}

		public Criteria andMonthNotIn(List<Integer> values) {
			addCriterion("month not in", values, "month");
			return this;
		}

		public Criteria andMonthBetween(Integer value1, Integer value2) {
			addCriterion("month between", value1, value2, "month");
			return this;
		}

		public Criteria andMonthNotBetween(Integer value1, Integer value2) {
			addCriterion("month not between", value1, value2, "month");
			return this;
		}

		public Criteria andDayIsNull() {
			addCriterion("day is null");
			return this;
		}

		public Criteria andDayIsNotNull() {
			addCriterion("day is not null");
			return this;
		}

		public Criteria andDayEqualTo(Integer value) {
			addCriterion("day =", value, "day");
			return this;
		}

		public Criteria andDayNotEqualTo(Integer value) {
			addCriterion("day <>", value, "day");
			return this;
		}

		public Criteria andDayGreaterThan(Integer value) {
			addCriterion("day >", value, "day");
			return this;
		}

		public Criteria andDayGreaterThanOrEqualTo(Integer value) {
			addCriterion("day >=", value, "day");
			return this;
		}

		public Criteria andDayLessThan(Integer value) {
			addCriterion("day <", value, "day");
			return this;
		}

		public Criteria andDayLessThanOrEqualTo(Integer value) {
			addCriterion("day <=", value, "day");
			return this;
		}

		public Criteria andDayIn(List<Integer> values) {
			addCriterion("day in", values, "day");
			return this;
		}

		public Criteria andDayNotIn(List<Integer> values) {
			addCriterion("day not in", values, "day");
			return this;
		}

		public Criteria andDayBetween(Integer value1, Integer value2) {
			addCriterion("day between", value1, value2, "day");
			return this;
		}

		public Criteria andDayNotBetween(Integer value1, Integer value2) {
			addCriterion("day not between", value1, value2, "day");
			return this;
		}
	}
}