package com.openyelp.data.shop.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShopCatalog implements Serializable {

	private Integer id;

	private String name;

	private List<ShopCatalog> clilds = new ArrayList<ShopCatalog>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ShopCatalog> getClilds() {
		return clilds;
	}

	public void setClilds(List<ShopCatalog> clilds) {
		this.clilds = clilds;
	}

	@Override
	public String toString() {
		return "ShopCatalog [id=" + id + ", name=" + name + "]";
	}
	
	

}
