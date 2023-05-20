package com.nbsaas.life.shop.data.entity;

import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.life.user.data.entity.UserInfo;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.Date;



@org.hibernate.annotations.Table(appliesTo = "shop_image",comment = "店铺的图片")
@Data
@Entity
@Table(name = "shop_image")
public class ShopImage extends AbstractEntity {



	private int num;

	@Comment("图片地址")
	@Column(length=300)
	private String url="";


	@Column(length = 1000)
	@Comment("消息")
	private String messages = "";

	@ManyToOne(fetch = FetchType.LAZY)
	@Comment("用户信息")
	private UserInfo user;

	@ManyToOne(fetch = FetchType.LAZY)
	@Comment("商店信息")
	private Shop shop;



}
