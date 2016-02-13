package com.openyelp.data.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "user_follow")
public class UserFollow {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	
	@ManyToOne
	@JoinColumn(name="userid")
	private UserInfo user;
	
	
	@ManyToOne
	@JoinColumn(name="friendid")
	private UserInfo friend;
	
	
	private Date addDate;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public UserInfo getUser() {
		return user;
	}


	public void setUser(UserInfo user) {
		this.user = user;
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
	
	

}
