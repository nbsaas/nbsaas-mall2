package com.openyelp.data.entity;

import com.ada.data.entity.CatalogEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shop_category")
public class ShopCategory extends CatalogEntity  {


	public static ShopCategory fromId(Integer id){
		
		ShopCategory result=new ShopCategory();
		result.setId(id);
		return result;
	}
	/**
	 * 分类别名
	 */
	private String cname;

	private String pinyin;
	
	private String py;
	
	private Long nums;



	private java.lang.String path;

	private java.lang.String icon;

	@JsonIgnore
	@JoinColumn(name = "pid")
	@ManyToOne
	private ShopCategory parent;

	@JsonIgnore
	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	private List<ShopCategory> childrens;

	public List<ShopCategory> getChildrens() {
		if (childrens != null && childrens.size() > 0) {
			return childrens;

		} else {
			return null;

		}
	}
	public String getCname() {
		return cname;
	}

	public java.lang.String getIcon() {
		return icon;
	}

	public Long getNums() {
		return nums;
	}

	public ShopCategory getParent() {
		return parent;
	}

	public Integer getParentId() {
		ShopCategory parent = getParent();
		if (parent != null) {
			return parent.getId();
		} else {
			return null;
		}
	}

	public java.lang.String getPath() {
		return path;
	}

	public String getPinyin() {
		return pinyin;
	}



	public String getPy() {
		return py;
	}


	@Override
	public String getTreeCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setChildrens(List<ShopCategory> childrens) {
		this.childrens = childrens;
	}






	public void setCname(String cname) {
		this.cname = cname;
	}

	public void setIcon(java.lang.String icon) {
		this.icon = icon;
	}


	public void setNums(Long nums) {
		this.nums = nums;
	}



	public void setParent(ShopCategory parent) {
		this.parent = parent;
	}

	public void setPath(java.lang.String path) {
		this.path = path;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}





	public void setPy(String py) {
		this.py = py;
	}




	
}
