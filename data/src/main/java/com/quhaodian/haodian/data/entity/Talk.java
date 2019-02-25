package com.quhaodian.haodian.data.entity;

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

import com.haoxuer.discover.user.data.entity.UserInfo;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

@Entity
@Table(name = "talk")
public class Talk {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;
	
	@Column(length=6000)
	private String message;
	
	@Column(length=6000)
	private String lastmessage;
	
	public String getLastmessage() {
		return lastmessage;
	}

	public void setLastmessage(String lastmessage) {
		this.lastmessage = lastmessage;
	}



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



	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userid")
	private UserInfo user;

	
	@ManyToOne
	@JoinColumn(name="areaid")
	private TalkCategoryArea area;


	public TalkCategoryArea getArea() {
		return area;
	}

	public void setArea(TalkCategoryArea area) {
		this.area = area;
	}

	public Date getAdddate() {
		return adddate;
	}

	public Long getId() {
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
		String safe="";
		if (topic!=null) {
			 safe = Jsoup.clean(topic, Whitelist.simpleText());
		}
		
		return safe;
	}



	public UserInfo getUser() {
		return user;
	}



	public void setAdddate(Date adddate) {
		this.adddate = adddate;
	}



	public void setId(Long id) {
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
