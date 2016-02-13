package com.openyelp.data.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_points")
public class UserPoints implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

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
	private Integer commentshop;

	/**
	 * 评论商店的时候获取积分
	 */
	private Integer commentposts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getAddshop() {
		return addshop;
	}

	public void setAddshop(Integer addshop) {
		this.addshop = addshop;
	}

	public Integer getCommentshop() {
		return commentshop;
	}

	public void setCommentshop(Integer commentshop) {
		this.commentshop = commentshop;
	}

	public Integer getCommentposts() {
		return commentposts;
	}

	public void setCommentposts(Integer commentposts) {
		this.commentposts = commentposts;
	}



}
