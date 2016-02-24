package com.openyelp.data.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ada.common.hibernate.HibernateTree;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.openyelp.annotation.NoGson;

/**
 * 地区
 * 
 * @author 年高
 *
 */
@Entity
@Table(name = "area")
public class Area implements HibernateTree<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private java.lang.String name;

	private Integer sortnum;

	private Integer code;
	
	private Integer state;

	

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	private java.lang.Integer lft;

	private java.lang.Integer rgt;
	
	/**
	 * 该地区的所有的父id，从高到低
	 */
	private String ids;

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	private Integer levelinfo;
	@JoinColumn(name = "pid")
	@ManyToOne(fetch=FetchType.EAGER)
	private Area parent;
	
	
	@JsonIgnore
	@NoGson
	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	private List<Area> childrens;

	public List<Area> getChildrens() {
		if (childrens != null && childrens.size() > 0) {
			return childrens;

		} else {
			return null;

		}
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public Integer getLevelinfo() {
		return levelinfo;
	}

	public java.lang.Integer getLft() {
		return lft;
	}

	/**
	 * @see HibernateTree#getLftName()
	 */
	public String getLftName() {
		return DEF_LEFT_NAME;
	}

	public java.lang.String getName() {
		return name;
	}

	public Area getParent() {
		return parent;
	}

	public Integer getParentId() {
		Area parent = getParent();
		if (parent != null) {
			return parent.getId();
		} else {
			return null;
		}
	}

	/**
	 * @see HibernateTree#getParentName()
	 */
	public String getParentName() {
		return DEF_PARENT_NAME;
	}

	public java.lang.Integer getRgt() {
		return rgt;
	}

	/**
	 * @see HibernateTree#getRgtName()
	 */
	public String getRgtName() {
		return DEF_RIGHT_NAME;
	}

	public Integer getSortnum() {
		return sortnum;
	}

	@Override
	public String getTreeCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setChildrens(List<Area> childrens) {
		this.childrens = childrens;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLevelinfo(Integer levelinfo) {
		this.levelinfo = levelinfo;
	}

	public void setLft(java.lang.Integer lft) {
		this.lft = lft;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public void setParent(Area parent) {
		this.parent = parent;
	}

	public void setRgt(java.lang.Integer rgt) {
		this.rgt = rgt;
	}

	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}

	@Override
	public String toString() {
		return "Area [id=" + id + ", name=" + name + ", lft=" + lft + ", rgt="
				+ rgt + ", levelinfo=" + levelinfo + "]";
	}
}
