package com.nbsaas.boot.shop.data.entity;

import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.user.data.entity.UserInfo;
import lombok.Data;

import javax.persistence.*;


/**
 * 商店评论每日之心
 * 
 * @author 年高
 *
 */

@Data
@Entity
@Table(name = "shop_review_good")
public class ShopReviewGood extends AbstractEntity {


	private String messages;

	@ManyToOne
	private UserInfo user;

	@ManyToOne()
	private ShopReview shopReview;


}
