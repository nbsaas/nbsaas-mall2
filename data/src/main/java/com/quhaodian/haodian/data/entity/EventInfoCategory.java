package com.quhaodian.haodian.data.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.quhaodian.data.entity.CatalogEntity;

@Entity
@Table(name = "eventinfo_category")
public class EventInfoCategory extends CatalogEntity {

	private java.lang.String path;

	private java.lang.String icon;

	@JoinColumn(name = "pid")
	@ManyToOne
	private EventInfoCategory parent;

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	private List<EventInfoCategory> childrens;

	public List<EventInfoCategory> getChildrens() {
		if (childrens != null && childrens.size() > 0) {
			return childrens;

		} else {
			return null;

		}
	}
	public java.lang.String getIcon() {
		return icon;
	}
	public EventInfoCategory getParent() {
		return parent;
	}
	public Integer getParentId() {
		EventInfoCategory parent = getParent();
		if (parent != null) {
			return parent.getId();
		} else {
			return null;
		}
	}
	public java.lang.String getPath() {
		return path;
	}
	@Override
	public String getTreeCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setChildrens(List<EventInfoCategory> childrens) {
		this.childrens = childrens;
	}

	public void setIcon(java.lang.String icon) {
		this.icon = icon;
	}

	public void setParent(EventInfoCategory parent) {
		this.parent = parent;
	}

	public void setPath(java.lang.String path) {
		this.path = path;
	}

}
