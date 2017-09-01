package com.openyelp.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.user.data.entity.UserInfo;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

@Entity
@Table(name = "talk_reply")
public class TalkReply {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;
	
	@Column(length=6000)
	private String message;
	
	@Column(length=100)
	private String topic;
	
	
	private  Date adddate;
	
	private Integer subscribe=0;


	private Integer replies=0;
	public Integer getReplies() {
		return replies;
	}

	public void setReplies(Integer replies) {
		this.replies = replies;
	}



	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userid")
	private UserInfo user;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="talkid")
	private Talk talk;


	public Talk getTalk() {
		return talk;
	}

	public void setTalk(Talk talk) {
		this.talk = talk;
	}

	public Date getAdddate() {
		return adddate;
	}

	public Integer getId() {
		return id;
	}

	public String getMessage() {
		String safe="";
		if (message!=null) {
			 safe = Jsoup.clean(message, Whitelist.basic());
		}
		
		return safe;
	}



	public Integer getSubscribe() {
		return subscribe;
	}



	public String getTopic() {
		return topic;
	}



	public UserInfo getUser() {
		return user;
	}



	public void setAdddate(Date adddate) {
		this.adddate = adddate;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public void setSubscribe(Integer subscribe) {
		this.subscribe = subscribe;
	}



	public void setTopic(String topic) {
		this.topic = topic;
	}



	public void setUser(UserInfo user) {
		this.user = user;
	}
}
