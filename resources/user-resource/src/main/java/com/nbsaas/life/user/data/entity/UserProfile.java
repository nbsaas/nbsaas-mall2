package com.nbsaas.life.user.data.entity;

import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * 用户的个人资料
 * @author 年高
 *
 */

@Data
@Entity
@Table(name = "user_profile")
public class UserProfile extends AbstractEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	@OneToOne
	@JoinColumn(name="userid",unique = true)
	private UserInfo user;
	




	/**
	 * 博客地址
	 */
	@Column(length=100)
	private String blog;

	/**
	 * 博客地址
	 */
	@Column(length=100)
	private String reviews;
	
	
	
	/**
	 * 博客地址
	 */
	@Column(length=100)
	private String  last_name;
	/**
	 * 喜欢的书籍
	 */
	@Column(length=100)
	private String book;



	/**
	 * 喜欢的歌手
	 */
	@Column(length=100)
	private String concert;



	/**
	 * 喜欢的偶像
	 */
	@Column(length=100)
	private String crush;



	/**
	 * 喜欢的动画人物
	 */
	@Column(length=100)
	private String donttell;



	/**
	 * 喜欢的电影
	 */
	@Column(length=100)
	private String film;
	
	
	/**
	 * 我常去的地方
	 */
	@Column(length=100)
	private String find_me_in;

	
	/**
	 * 我的姓
	 */
	@Column(length=100)
	private String first_name;
	
	
	/**
	 * 家乡
	 */
	@Column(length=100)
	private String hometown;
	
	
	/**
	 * 家乡
	 */
	@Column(length=100)
	private String lastmeal;
	
	
	/**
	 * 喜欢的名称
	 */
	@Column(length=100)
	private String love_name;
	
	
	
	/**
	 * 我的外号
	 */
	@Column(length=100)
	private String nickname;
	
	
	
	/**
	 * 喜欢做的事情
	 */
	@Column(length=100)
	private String notyelp;
	
	
	/**
	 * 语言
	 */
	@Column(length=100)
	private String primary_locale;
	
	
	/**
	 * 喜欢的东西
	 */
	@Column(length=100)
	private String recentdiscovery;
	
	
	/**
	 * 第二网址
	 */
	@Column(length=100)
	private String secondsite;
	
	/**
	 * 个人签名
	 */
	@Column(length=200)
	private String tagline;
	
	

	
	
}
