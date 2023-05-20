package com.nbsaas.life.shop.data.entity;


import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.life.user.data.entity.UserInfo;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "shop_bookmarks")
public class ShopBookMarks extends AbstractEntity {

	

	
	@Column(length=100)
	private String label;
	
	
	private String messages;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userid")
	private UserInfo user;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="shopid")
	private Shop shop;



}
