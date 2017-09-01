package com.openyelp.data.entity;

import com.ada.user.data.entity.UserInfo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name = "eventinfo_join")
public class EventInfoJoin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name="userid")
	private UserInfo user;
	

	@ManyToOne
	@JoinColumn(name = "eventInfoid")
	private EventInfo eventInfo;
	
	private Date addDate;
	/**
	 * 类型
	 */
	private Integer type;
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
	public EventInfo getEventInfo() {
		return eventInfo;
	}
	public void setEventInfo(EventInfo eventInfo) {
		this.eventInfo = eventInfo;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
}
