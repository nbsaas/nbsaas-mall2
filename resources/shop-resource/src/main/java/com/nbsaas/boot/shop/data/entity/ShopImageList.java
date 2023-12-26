package com.nbsaas.boot.shop.data.entity;


import com.nbsaas.boot.user.data.entity.UserInfo;
import com.nbsaas.boot.area.data.entity.Area;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;



@Data
@Entity
@Table(name = "shop_image_list")
public class ShopImageList extends AbstractEntity {
	
	

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "shop_image_list_links")
	private Set<ShopImage> images;
	
	

	private Integer num;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private UserInfo user;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Area area;
	

	@ManyToOne(fetch=FetchType.EAGER)
	private Shop shop;



}
