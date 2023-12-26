package com.nbsaas.boot.shop.data.entity;


import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.user.data.entity.UserInfo;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "shop_bookmarks")
public class ShopBookMarks extends AbstractEntity {

	

	
	@Column(length=100)
	private String label;
	
	
	private String messages;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private UserInfo user;

	@ManyToOne(fetch=FetchType.LAZY)
	private Shop shop;



}
