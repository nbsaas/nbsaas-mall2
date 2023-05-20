package com.nbsaas.life.shop.data.entity;


import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.life.user.data.entity.UserInfo;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * 商店评论
 * 
 * @author 年高
 *
 */

@Data
@Entity
@Table(name = "shop_review_vote")
public class ShopReviewVote extends AbstractEntity {


	@ManyToOne(fetch = FetchType.EAGER)
	private UserInfo user;

	@ManyToOne(fetch = FetchType.EAGER)
	private ShopReview review;

	/**
	 * 1为有用 2 为有形 3为有趣
	 */
	private int catalog;


}
