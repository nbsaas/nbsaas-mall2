package com.nbsaas.life.shop.data.entity;


import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.life.user.data.entity.UserInfo;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.Date;


/**
 * 商店评论
 * 
 * @author 年高
 *
 */

@org.hibernate.annotations.Table(appliesTo = "shop_review",comment = "商店评论")
@Data
@Entity
@Table(name = "shop_review")
public class ShopReview extends AbstractEntity {

	@Comment("店铺id")
	@ManyToOne
	private Shop shop;

	@Comment("服务评分")
	@Column(name = "service_score")
	private Integer serviceScore;

	@Comment("价格评分")
	@Column(name = "price_score")
	private Integer priceScore;

	@Comment("投票1")
	@Column(name = "vote_1")
	private Integer vote1;

	@Comment("投票2")
	@Column(name = "vote_2")
	private Integer vote2;

	@Comment("投票3")
	@Column(name = "vote_3")
	private Integer vote3;

	@Comment("用户id")
	@ManyToOne
	private UserInfo user;

	@Comment("评论")
	private String comment;

	@Comment("环境氛围")
	private String ambience;

	@Comment("预定")
	private String reservations;

	@Comment("是否接受信用卡")
	@Column(name = "business_accepts_credit_cards")
	private String businessAcceptsCreditCards;

	@Comment("停车场")
	private String parking;

	@Comment("是否有单车停车位")
	@Column(name = "bike_parking")
	private String bikeParking;

	@Comment("衣著")
	private String attire;

	@Comment("是否适合团体")
	@Column(name = "good_for_groups")
	private String goodForGroups;

	@Comment("是否适合儿童")
	@Column(name = "good_for_kids")
	private String goodForKids;

	@Comment("是否提供外送")
	@Column(name = "delivery")
	private String delivery;

	@Comment("是否接受外带")
	@Column(name = "takeout")
	private String takeout;

	@Comment("是否有服务生服务")
	@Column(name = "table_service")
	private String tableService;

	@Comment("是否提供户外座位")
	@Column(name = "outdoor_seating")
	private String outdoorSeating;

	@Comment("Wi-Fi")
	private String wifi;

	@Comment("适合早餐")
	@Column(name = "good_for_meal_breakfast")
	private String goodForMealBreakfast;

	@Comment("酒类饮品")
	private String alcohol;

	@Comment("噪音音量")
	@Column(name = "noise_level")
	private String noiseLevel;

	@Comment("是否有电视")
	@Column(name = "has_tv")
	private String hasTV;

	@Comment("是否承办宴席")
	private String caters;


}
