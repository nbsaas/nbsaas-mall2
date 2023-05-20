package com.nbsaas.life.shop.data.entity;

import com.nbsaas.boot.jpa.data.entity.AbstractEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;




@Entity
@Table(name = "shop_review_list_item")
public class ShopReviewListItem extends AbstractEntity {

	

	@ManyToOne
	@JoinColumn
	private ShopReviewList list;
	
	

	private Date addDate;
	
	private int num;


	
}
