package com.quhaodian.haodian.data.entity;

import com.quhaodian.area.data.entity.Area;
import com.quhaodian.user.data.entity.UserInfo;

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



@Entity
@Table(name = "shop_review_list")
public class ShopReviewList implements Serializable {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id;

	private String note;
	
	private String title;

	private Date addDate;
	
	private Date lastDate;

	@ManyToOne
	@JoinColumn(name = "userid")
	private UserInfo user;


	@ManyToOne
	@JoinColumn
	private Area area;


	public Date getAddDate() {
		return addDate;
	}


	public Area getArea() {
		return area;
	}


	public Long getId() {
		return id;
	}
	
	public Date getLastDate() {
		return lastDate;
	}
	

	public String getNote() {
		return note;
	}


	public String getTitle() {
		return title;
	}


	public UserInfo getUser() {
		return user;
	}


	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}


	public void setArea(Area area) {
		this.area = area;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setUser(UserInfo user) {
		this.user = user;
	}

	
	
	
	
	
	
}
