package com.demo.hibernate.beans;

import java.io.Serializable;

/**
 * @author Hibernate CodeGenerator
 */
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
	private Integer id;

	/** persistent field */
	private String username;

	/** persistent field */
	private String name;

	/** nullable persistent field */
	private String sex;

	/** nullable persistent field */
	private String mobile;

	/** nullable persistent field */
	private String email;

	/** nullable persistent field */
	private String qq;

	/** nullable persistent field */
	private String company;

	/** nullable persistent field */
	private String address;

	/** nullable persistent field */
	private String postcode;

	/** full constructor */
	public Address(Integer id, String username, String name, String sex, String mobile, String email, String qq,
			String company, String address, String postcode) {
		this.id = id;
		this.username = username;
		this.name = name;
		this.sex = sex;
		this.mobile = mobile;
		this.email = email;
		this.qq = qq;
		this.company = company;
		this.address = address;
		this.postcode = postcode;
	}

	/** default constructor */
	public Address() {
	}

	/** minimal constructor */
	public Address(Integer id, String username, String name) {
		this.id = id;
		this.username = username;
		this.name = name;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

}
