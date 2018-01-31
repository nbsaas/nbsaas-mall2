package com.quhaodian.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.quhaodian.common.hibernate.HibernateTree;

@Entity
@Table(name = "channel")
public class Channel implements HibernateTree<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	public void setId(Integer id) {
		this.id = id;
	}

	private java.lang.String name;

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	private java.lang.String path;
	private java.lang.Integer lft;
	private java.lang.Integer rgt;

	private Integer levelinfo;

	public Integer getLevelinfo() {
		return levelinfo;
	}

	public void setLevelinfo(Integer levelinfo) {
		this.levelinfo = levelinfo;
	}

	public java.lang.String getPath() {
		return path;
	}

	public void setPath(java.lang.String path) {
		this.path = path;
	}

	public java.lang.Integer getLft() {
		return lft;
	}

	public void setLft(java.lang.Integer lft) {
		this.lft = lft;
	}

	public java.lang.Integer getRgt() {
		return rgt;
	}

	public void setRgt(java.lang.Integer rgt) {
		this.rgt = rgt;
	}

	/**
	 * @see HibernateTree#getLftName()
	 */
	public String getLftName() {
		return DEF_LEFT_NAME;
	}

	/**
	 * @see HibernateTree#getParentName()
	 */
	public String getParentName() {
		return DEF_PARENT_NAME;
	}

	/**
	 * @see HibernateTree#getRgtName()
	 */
	public String getRgtName() {
		return DEF_RIGHT_NAME;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getTreeCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	@JoinColumn(name = "pid")
	@ManyToOne
	private Channel parent;

	public Channel getParent() {
		return parent;
	}

	public void setParent(Channel parent) {
		this.parent = parent;
	}

	public Integer getParentId() {
		Channel parent = getParent();
		if (parent != null) {
			return parent.getId();
		} else {
			return null;
		}
	}
}
