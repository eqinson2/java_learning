package com.demo.hibernate.beans;

import java.io.Serializable;

/**
 * @author Hibernate CodeGenerator
 */
public class Sms implements Serializable {
	private static final long serialVersionUID = 1L;

	/** identifier field */
	private Integer id;

	/** persistent field */
	private String username;

	/** persistent field */
	private String sender;

	/** nullable persistent field */
	private String message;

	/** nullable persistent field */
	private String sendtime;

	/** nullable persistent field */
	private String isRead;

	/** full constructor */
	public Sms(Integer id, String username, String sender, String message, String sendtime, String isRead) {
		this.id = id;
		this.username = username;
		this.sender = sender;
		this.message = message;
		this.sendtime = sendtime;
		this.isRead = isRead;
	}

	/** default constructor */
	public Sms() {
	}

	/** minimal constructor */
	public Sms(Integer id, String username, String sender) {
		this.id = id;
		this.username = username;
		this.sender = sender;
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

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	public String getIsRead() {
		return this.isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

}
