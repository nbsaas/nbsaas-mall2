package com.haoxuer.haodian.data.entity;

import com.haoxuer.discover.user.data.entity.UserInfo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "notification_info")
public class Notification implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private Date addDate=new Date();
	
	private Date lastDate=new Date();

	/**
	 * 
	 */
	@JoinColumn(name = "userid")
	@ManyToOne()
	private UserInfo userInfo;
	/**
	 * 提醒分类 1我的帖子 2坛友互动 3系统消息 4管理工作 0应用消息
	 */
	private Integer category;
	
	private Integer state;

	/**
	 * 其他表的id
	 */
	private Long oid;
	
	
	public Long getOid() {
		return oid;
	}
	public void setOid(Long oid) {
		this.oid = oid;
	}
	private String note;
	
	private String title;
	
	@JoinColumn(name = "fromid")
	@ManyToOne()
	private UserInfo from;
	
	private String name;
	private String headimg;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public UserInfo getFrom() {
		return from;
	}
	public void setFrom(UserInfo from) {
		this.from = from;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeadimg() {
		return headimg;
	}
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	
	
	
}
