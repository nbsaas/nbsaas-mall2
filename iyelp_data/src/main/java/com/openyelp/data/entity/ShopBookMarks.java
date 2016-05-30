package com.openyelp.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.user.entity.UserInfo;


@Entity
@Table(name = "shop_bookmarks")
public class ShopBookMarks {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;
	
	
	private  Date addDate;
	
	@Column(length=100)
	private String label;
	
	
	private String messages;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userid")
	private UserInfo user;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="shopid")
	private Shop shop;


	public Date getAddDate() {
		return addDate;
	}


	public Long getId() {
		return id;
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


	public void setShop(Shop shop) {
		this.shop = shop;
	}



	public void setUser(UserInfo user) {
		this.user = user;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public String getMessages() {
		return messages;
	}


	public void setMessages(String messages) {
		this.messages = messages;
	}
	
	

}
