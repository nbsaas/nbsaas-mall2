package com.quhaodian.data.entity;

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
@Table(name = "shop_image")
public class ShopImage {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;
	
	private int num;

	private  Date addDate=new Date();
	
	@Column(length=500)
	private String url="";
	@Column(length=1000)
	private String messages="";
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userid")
	private UserInfo user;


	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="shopid")
	private Shop shop;


	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Date getAddDate() {
		return addDate;
	}

	public Long getId() {
		return id;
	}


	public String getMessages() {
		return messages;
	}


	public Shop getShop() {
		return shop;
	}

	public String getUrl() {
		return url;
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


	public void setMessages(String messages) {
		this.messages = messages;
	}


	public void setShop(Shop shop) {
		this.shop = shop;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public void setUser(UserInfo user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShopImage other = (ShopImage) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
	

}
