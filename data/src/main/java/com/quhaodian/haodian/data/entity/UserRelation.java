package com.quhaodian.haodian.data.entity;

import com.quhaodian.user.data.entity.UserInfo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name = "user_relation")
public class UserRelation {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	
	@ManyToOne
	@JoinColumn(name="userid")
	private UserInfo user;
	
	
	@ManyToOne
	@JoinColumn(name="friendid")
	private UserInfo friend;
	
	private Integer state;
	
	@Column(length=500)
	private String message;
	
	private Date addDate;
	
	private Date lastDate;

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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
	
	
	
}
