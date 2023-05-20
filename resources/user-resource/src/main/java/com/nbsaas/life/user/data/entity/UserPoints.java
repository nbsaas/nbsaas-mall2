package com.nbsaas.life.user.data.entity;

import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "user_points")
public class UserPoints extends AbstractEntity {

	@ManyToOne
	private UserInfo user;
	/**
	 * 所有积分
	 */
	private Integer points;

	/**
	 * 增加一个商店
	 */
	private Integer addshop;
	/**
	 * 添加的商店被别人评价后
	 */
	private Integer commentShop;

	/**
	 * 评论商店的时候获取积分
	 */
	private Integer commentPosts;


}
