package com.nbsaas.boot.shop.data.entity;

import com.nbsaas.boot.user.data.entity.UserInfo;
import com.nbsaas.boot.area.data.entity.Area;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "shop_review_list")
public class ShopReviewList extends AbstractEntity {

	

	private String note;
	
	private String title;


	@ManyToOne
	private UserInfo user;


	@ManyToOne
	@JoinColumn
	private Area area;


}
