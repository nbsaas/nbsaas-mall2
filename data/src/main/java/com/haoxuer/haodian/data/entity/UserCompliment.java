package com.haoxuer.haodian.data.entity;

import com.haoxuer.discover.user.data.entity.UserInfo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 赞美
 * 
 * @author andrea
 *
 */

@Entity
@Table(name = "user_compliment")
public class UserCompliment implements Serializable {

	/**
	 * 评论Id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private long id;

	private Date addDate;
	
	private String messages;
	
	
	@ManyToOne
	@JoinColumn(name="userid")
	private UserInfo userInfo;
	
	
	@ManyToOne
	@JoinColumn(name="complimentid")
	private UserInfo compliment;
	/**
	 * 类型
	 */
	private  String type;
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * 0为初始状态 1为审核通过
	 */
	private Integer state;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public UserInfo getCompliment() {
		return compliment;
	}

	public void setCompliment(UserInfo compliment) {
		this.compliment = compliment;
	}
	
	
	
}
