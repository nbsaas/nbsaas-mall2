package com.quhaodian.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.user.entity.UserInfo;

/**
 * 商店评论
 * 
 * @author 年高
 *
 */
@Entity
@Table(name = "shop_review")
public class ShopReview {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "shopid")
	private Shop shop;

	private Integer servicescore;

	private Integer pricescore;
	
	private Integer vote1;
	private Integer vote2;
	private Integer vote3;
	
	public Integer getVote1() {
		return vote1;
	}

	public void setVote1(Integer vote1) {
		this.vote1 = vote1;
	}

	@Override
	public String toString() {
		return "ShopReview [id=" + id + ", shop=" + shop + "]";
	}

	public Integer getVote2() {
		return vote2;
	}

	public void setVote2(Integer vote2) {
		this.vote2 = vote2;
	}

	public Integer getVote3() {
		return vote3;
	}

	public void setVote3(Integer vote3) {
		this.vote3 = vote3;
	}

	@ManyToOne
	@JoinColumn(name = "userid")
	private UserInfo user;

	private Date addDate;

	private Date lastDate;

	private String comment;

	public String getComment() {
		return comment;
	}

	/**
	 * 环境氛围
	 */
	private String ambience;
	/**
	 * 预定
	 */
	private String reservations;
	/**
	 * 是否接受信用卡
	 */
	private String businessacceptscreditcards;
	/**
	 * 停车场
	 */
	private String businessparking;
	/**
	 * 是否有单车停车位
	 */
	private String bikeparking;
	/**
	 * 衣著
	 */
	private String restaurantsattire;

	/**
	 * 是否适合团体
	 */
	private String restaurantsgoodforgroups;

	/**
	 * 是否适合儿童
	 */
	private String goodforkids;

	/**
	 * 是否提供外送
	 */
	private String restaurantsdelivery;

	/**
	 * 是否接受外带
	 */
	private String restaurantstakeout;

	/**
	 * 是否有服务生服务
	 */
	private String restaurantstableservice;

	/**
	 * 是否提供户外座位
	 */
	private String outdoorseating;

	/**
	 * Wi-Fi
	 */
	private String wifi;

	/**
	 * 适合
	 */
	private String goodformeal_breakfast;

	/**
	 * 酒类饮品
	 */
	private String alcohol;

	/**
	 * 噪音音量
	 */
	private String noiselevel;
	/**
	 * 是否有电视
	 */
	private String hastv;

	/**
	 * 是否承办宴席
	 */
	private String caters;

	public String getAmbience() {
		return ambience;
	}

	public void setAmbience(String ambience) {
		this.ambience = ambience;
	}

	public String getReservations() {
		return reservations;
	}

	public void setReservations(String reservations) {
		this.reservations = reservations;
	}

	public String getBusinessacceptscreditcards() {
		return businessacceptscreditcards;
	}

	public void setBusinessacceptscreditcards(String businessacceptscreditcards) {
		this.businessacceptscreditcards = businessacceptscreditcards;
	}

	public String getBusinessparking() {
		return businessparking;
	}

	public void setBusinessparking(String businessparking) {
		this.businessparking = businessparking;
	}

	public String getBikeparking() {
		return bikeparking;
	}

	public void setBikeparking(String bikeparking) {
		this.bikeparking = bikeparking;
	}

	public String getRestaurantsattire() {
		return restaurantsattire;
	}

	public void setRestaurantsattire(String restaurantsattire) {
		this.restaurantsattire = restaurantsattire;
	}

	public String getRestaurantsgoodforgroups() {
		return restaurantsgoodforgroups;
	}

	public void setRestaurantsgoodforgroups(String restaurantsgoodforgroups) {
		this.restaurantsgoodforgroups = restaurantsgoodforgroups;
	}

	public String getGoodforkids() {
		return goodforkids;
	}

	public void setGoodforkids(String goodforkids) {
		this.goodforkids = goodforkids;
	}

	public String getRestaurantsdelivery() {
		return restaurantsdelivery;
	}

	public void setRestaurantsdelivery(String restaurantsdelivery) {
		this.restaurantsdelivery = restaurantsdelivery;
	}

	public String getRestaurantstakeout() {
		return restaurantstakeout;
	}

	public void setRestaurantstakeout(String restaurantstakeout) {
		this.restaurantstakeout = restaurantstakeout;
	}

	public String getRestaurantstableservice() {
		return restaurantstableservice;
	}

	public void setRestaurantstableservice(String restaurantstableservice) {
		this.restaurantstableservice = restaurantstableservice;
	}

	public String getOutdoorseating() {
		return outdoorseating;
	}

	public void setOutdoorseating(String outdoorseating) {
		this.outdoorseating = outdoorseating;
	}

	public String getWifi() {
		return wifi;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	public String getGoodformeal_breakfast() {
		return goodformeal_breakfast;
	}

	public void setGoodformeal_breakfast(String goodformeal_breakfast) {
		this.goodformeal_breakfast = goodformeal_breakfast;
	}

	public String getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}

	public String getNoiselevel() {
		return noiselevel;
	}

	public void setNoiselevel(String noiselevel) {
		this.noiselevel = noiselevel;
	}

	public String getHastv() {
		return hastv;
	}

	public void setHastv(String hastv) {
		this.hastv = hastv;
	}

	public String getCaters() {
		return caters;
	}

	public void setCaters(String caters) {
		this.caters = caters;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public ShopReview() {
		addDate = new Date();
		lastDate = new Date();
		servicescore = 0;
		pricescore = 0;
	}

	public Integer getServicescore() {
		return servicescore;
	}

	public void setServicescore(Integer servicescore) {
		this.servicescore = servicescore;
	}

	public Integer getPricescore() {
		return pricescore;
	}

	public void setPricescore(Integer pricescore) {
		this.pricescore = pricescore;
	}

	public Date getAddDate() {
		return addDate;
	}

	public Long getId() {
		return id;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public Shop getShop() {
		return shop;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

}
