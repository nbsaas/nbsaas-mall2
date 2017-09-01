package com.openyelp.data.entity;

import com.ada.user.data.entity.UserInfo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 商店评论每日之心
 * 
 * @author 年高
 *
 */
@Entity
@Table(name = "shop_review_good")
public class ShopReviewGood {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id;

	private String messages;

	@ManyToOne
	@JoinColumn(name = "userid")
	private UserInfo user;

	@ManyToOne()
	@JoinColumn(name = "shopreviewid")
	private ShopReview shopReview;

	public ShopReview getShopReview() {
		return shopReview;
	}

	public void setShopReview(ShopReview shopReview) {
		this.shopReview = shopReview;
	}

	private Date addDate = new Date();
	private Date goodDate = new Date();

	public Date getGoodDate() {
		return goodDate;
	}

	public void setGoodDate(Date goodDate) {
		this.goodDate = goodDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

}
