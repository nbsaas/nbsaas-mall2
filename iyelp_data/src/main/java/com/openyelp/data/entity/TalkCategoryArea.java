package com.openyelp.data.entity;

import com.ada.area.data.entity.Area;

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


@Entity
@Table(name = "talk_category_area")
public class TalkCategoryArea {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "areaid")
	private Area area;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "talkcategoryid")
	private TalkCategory talkCategory;

	private Date addDate;

	private Date lastDate;

	private Integer size;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public TalkCategory getTalkCategory() {
		return talkCategory;
	}

	public void setTalkCategory(TalkCategory talkCategory) {
		this.talkCategory = talkCategory;
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

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
}
