package com.demo.hibernate.beans;

import java.io.Serializable;

/**
 * @author Hibernate CodeGenerator
 */
public class Notice implements Serializable {
	private static final long serialVersionUID = 1L;

	/** identifier field */
	private Integer id;

	/** persistent field */
	private String sender;

	/** nullable persistent field */
	private String title;

	/** nullable persistent field */
	private String content;

	/** nullable persistent field */
	private String sendtime;

	/** full constructor */
	public Notice(Integer id, String sender, String title, String content, String sendtime) {
		this.id = id;
		this.sender = sender;
		this.title = title;
		this.content = content;
		this.sendtime = sendtime;
	}

	/** default constructor */
	public Notice() {
	}

	/** minimal constructor */
	public Notice(Integer id, String sender) {
		this.id = id;
		this.sender = sender;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

}
