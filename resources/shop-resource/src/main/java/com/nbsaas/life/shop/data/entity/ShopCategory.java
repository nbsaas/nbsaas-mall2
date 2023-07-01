package com.nbsaas.life.shop.data.entity;


import com.nbsaas.boot.code.annotation.CatalogClass;
import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.code.annotation.SearchItem;
import com.nbsaas.boot.jpa.data.entity.CatalogEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@FormAnnotation(title = "商家分类", model = "商家分类")
@CatalogClass(lazyData = true)
@Data
@Entity
@Table(name = "shop_category")
public class ShopCategory extends CatalogEntity {


	public static ShopCategory fromId(Long id){

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


	private String path;

	private String icon;

	@SearchItem(label = "父分类", name = "parent", key = "parent.id", operator = "eq", classType = Long.class)
	@ManyToOne(fetch = FetchType.LAZY)
	private ShopCategory parent;

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	private List<ShopCategory> children;


	@Override
	public Serializable getParentId() {
		if (parent != null) {
			return parent.getId();
		}
		return null;
	}
}
