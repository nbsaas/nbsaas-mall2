package com.quhaodian.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.user.data.entity.UserInfo;

/**
 * 活动精选
 * @author andrea
 *
 */
@Entity
@Table(name = "eventinfo_good")
public class EventInfoGood {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column()
	private Long id;



	private String messages;

	@ManyToOne
	@JoinColumn(name = "userinfoid")
	private UserInfo userInfo;

	@ManyToOne
	@JoinColumn(name = "eventinfoid")
	private EventInfo eventinfo;

	private Date addDate=new Date();

	public Date getAddDate() {
		return addDate;
	}

	
	public EventInfo getEventinfo() {
		return eventinfo;
	}
	
	
	public Long getId() {
		return id;
	}

	public String getMessages() {
		return messages;
	}


	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public void setEventinfo(EventInfo eventinfo) {
		this.eventinfo = eventinfo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}


	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
