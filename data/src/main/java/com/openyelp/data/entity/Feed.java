package com.openyelp.data.entity;

import com.ada.area.data.entity.Area;
import com.ada.user.data.entity.UserInfo;

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
 * 动态
 * 
 * @author andrea
 *
 */
@Entity
@Table(name = "feed")
public class Feed implements Serializable {

	@Override
	public String toString() {
		return "Feed [id=" + id + ", oid=" + oid + ", catalog=" + catalog + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column()
	private Long id;

	@ManyToOne
	@JoinColumn(name = "userid")
	private UserInfo user;
	
	@ManyToOne
	@JoinColumn
	private Area area;

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	private String title;

	private String note;

	private Date addDate;

	private Long oid;

	/**
	 * 1评论 2 添加活动 3 添加照片
	 */
	private Integer catalog;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Integer getCatalog() {
		return catalog;
	}

	public void setCatalog(Integer catalog) {
		this.catalog = catalog;
	}
}
