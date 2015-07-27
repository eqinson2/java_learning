package com.eqinson.hibernate.beans;

import java.io.Serializable;

/**
 * @author Hibernate CodeGenerator
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
	private Integer id;

	/** nullable persistent field */
	private String username;

	/** nullable persistent field */
	private String password;

	/** nullable persistent field */
	private String email;

	/** full constructor */
	public User(Integer id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Integer id) {
		this.id = id;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
