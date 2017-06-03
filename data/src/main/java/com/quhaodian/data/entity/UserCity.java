package com.quhaodian.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.area.entity.Area;
import com.ada.user.entity.UserInfo;


/**
 * 用户的 关联的城市
 * @author 年高
 *
 */
@Entity
@Table(name = "user_city")
public class UserCity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name="userid")
	private UserInfo user;

	private Integer state;
	
	@ManyToOne
	@JoinColumn(name="areaid")
	private Area area;


	@Column(length=150)
	private String address;


	private Date lastDate;
	
	/**
	 * 地点的名称
	 */
	
	
	@Column(length=100)
	private String name;
	
	
	
	
	private Date addDate;


	public Date getAddDate() {
		return addDate;
	}


	public String getAddress() {
		return address;
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


	public String getName() {
		return name;
	}


	public Integer getState() {
		return state;
	}


	public UserInfo getUser() {
		return user;
	}


	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}


	public void setAddress(String address) {
		this.address = address;
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


	public void setName(String name) {
		this.name = name;
	}


	public void setState(Integer state) {
		this.state = state;
	}


	public void setUser(UserInfo user) {
		this.user = user;
	}
	
	
}
