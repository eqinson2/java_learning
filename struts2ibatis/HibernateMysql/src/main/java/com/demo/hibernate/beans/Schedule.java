package com.demo.hibernate.beans;

import java.io.Serializable;

/**
 * @author Hibernate CodeGenerator
 */
public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;

	/** identifier field */
	private Integer id;

	/** persistent field */
	private String username;

	/** nullable persistent field */
	private Integer year;

	/** nullable persistent field */
	private Integer month;

	/** nullable persistent field */
	private Integer day;

	/** nullable persistent field */
	private String plan;

	/** full constructor */
	public Schedule(Integer id, String username, Integer year, Integer month, Integer day, String plan) {
		this.id = id;
		this.username = username;
		this.year = year;
		this.month = month;
		this.day = day;
		this.plan = plan;
	}

	/** default constructor */
	public Schedule() {
	}

	/** minimal constructor */
	public Schedule(Integer id, String username) {
		this.id = id;
		this.username = username;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return this.month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return this.day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public String getPlan() {
		return this.plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

}
