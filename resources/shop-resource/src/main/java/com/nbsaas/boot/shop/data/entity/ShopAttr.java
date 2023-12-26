package com.nbsaas.boot.shop.data.entity;

import com.nbsaas.boot.jpa.data.entity.SortEntity;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "shop_attr")
public class ShopAttr extends SortEntity {

	


	@Column(length=100)
	private String url;
	

	private String keyName;

	private String keyValue;

	private String keyType;

	@ManyToOne(fetch= FetchType.LAZY)
	private Shop shop;

	

}
