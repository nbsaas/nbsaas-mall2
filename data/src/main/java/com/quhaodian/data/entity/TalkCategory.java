package com.quhaodian.data.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ada.common.hibernate.HibernateTree;
import com.ada.data.entity.CatalogEntity;

@Entity
@Table(name = "talk_category")
public class TalkCategory extends CatalogEntity {


	private String path;

	private String icon;


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


	public java.lang.String getPath() {
		return path;
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


	public void setParent(TalkCategory parent) {
		this.parent = parent;
	}

	public void setPath(java.lang.String path) {
		this.path = path;
	}

}
