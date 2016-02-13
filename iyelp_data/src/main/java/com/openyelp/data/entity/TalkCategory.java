package com.openyelp.data.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ada.common.hibernate.HibernateTree;

@Entity
@Table(name = "talk_category")
public class TalkCategory implements HibernateTree<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Integer id;

	private java.lang.String name;

	private Integer sortnum;

	public Integer getSortnum() {
		return sortnum;
	}

	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}

	private java.lang.String path;

	private java.lang.String icon;

	private java.lang.String ids;

	private java.lang.Integer lft;
	private java.lang.Integer rgt;
	private Integer levelinfo;

	@JoinColumn(name = "pid")
	@ManyToOne
	private TalkCategory parent;

	@OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
	private List<TalkCategory> childrens;

	public List<TalkCategory> getChildrens() {
		if (childrens != null && childrens.size() > 0) {
			return childrens;

		} else {
			return null;

		}
	}

	public java.lang.String getIcon() {
		return icon;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public java.lang.String getIds() {
		return ids;
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

	public TalkCategory getParent() {
		return parent;
	}

	public Integer getParentId() {
		TalkCategory parent = getParent();
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

	public java.lang.String getPath() {
		return path;
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

	@Override
	public String getTreeCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setChildrens(List<TalkCategory> childrens) {
		this.childrens = childrens;
	}

	public void setIcon(java.lang.String icon) {
		this.icon = icon;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIds(java.lang.String ids) {
		this.ids = ids;
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

	public void setParent(TalkCategory parent) {
		this.parent = parent;
	}

	public void setPath(java.lang.String path) {
		this.path = path;
	}

	public void setRgt(java.lang.Integer rgt) {
		this.rgt = rgt;
	}
}
