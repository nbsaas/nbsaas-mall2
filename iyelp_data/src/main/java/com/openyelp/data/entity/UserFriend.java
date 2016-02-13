package com.openyelp.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "user_friend")
public class UserFriend implements Serializable {

	
	public UserFriend(){
		addDate=new Date();
		lastDate=new Date();
	}
	@Id
	@GeneratedValue
	private Long id;
	
	/**
	 * 用户
	 */
	@JoinColumn(name="userid")
	@ManyToOne()
	private UserInfo user;
	
	
	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}
	/**
	 * 用户
	 */
	@JoinColumn(name="friendid")
	@ManyToOne()
	private UserInfo friend;
	
	private Date addDate;
	
	private Date lastDate;
	
	private String note;
	
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public UserInfo getFriend() {
		return friend;
	}

	public void setFriend(UserInfo friend) {
		this.friend = friend;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
