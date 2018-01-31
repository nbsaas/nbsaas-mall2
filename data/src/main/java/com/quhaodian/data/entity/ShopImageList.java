package com.quhaodian.data.entity;

import com.quhaodian.area.data.entity.Area;
import com.quhaodian.user.data.entity.UserInfo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name = "shop_image_list")
public class ShopImageList {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "shop_image_list_links")
	private Set<ShopImage> images;
	
	
	private Date addDate;
	
	private Date lastDate;
	
	private Integer num;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userid")
	private UserInfo user;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "areaid")
	private Area area;
	

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="shopid")
	private Shop shop;


	public Shop getShop() {
		return shop;
	}


	public void setShop(Shop shop) {
		this.shop = shop;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Set<ShopImage> getImages() {
		return images;
	}


	public void setImages(Set<ShopImage> images) {
		this.images = images;
	}


	public Date getAddDate() {
		return addDate;
	}


	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}


	public Date getLastDate() {
		return lastDate;
	}


	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}


	public Integer getNum() {
		return num;
	}


	public void setNum(Integer num) {
		this.num = num;
	}


	public UserInfo getUser() {
		return user;
	}


	public void setUser(UserInfo user) {
		this.user = user;
	}


	public Area getArea() {
		return area;
	}


	public void setArea(Area area) {
		this.area = area;
	}
	
	


}
