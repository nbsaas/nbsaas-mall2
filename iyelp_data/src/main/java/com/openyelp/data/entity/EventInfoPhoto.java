package com.openyelp.data.entity;

import com.ada.user.data.entity.UserInfo;

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
@Table(name = "eventinfo_photo")
public class EventInfoPhoto {

	private Date addDate;

	@ManyToOne
	@JoinColumn(name = "eventinfoid")
	private EventInfo eventinfo;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column()
	private Long id;

	private String messages;

	private Integer typeinfo;

	private String url;

	@ManyToOne
	@JoinColumn(name = "userinfoid")
	private UserInfo user;

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

	public int getPhoto() {
		int result = 0;

		String uurl = getUser().getAvatar();
		if (uurl != null && uurl.equals(url)) {
			result = 1;
		}
		return result;
	}

	public Integer getTypeinfo() {
		return typeinfo;
	}

	public String getUrl() {
		return url;
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

	public void setTypeinfo(Integer typeinfo) {
		this.typeinfo = typeinfo;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public UserInfo getUser() {
		return user;
	}


	public void setUser(UserInfo user) {
		this.user = user;
	}


}
