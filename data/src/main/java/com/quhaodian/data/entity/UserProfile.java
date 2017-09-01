package com.quhaodian.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ada.user.entity.UserInfo;
/**
 * 用户的个人资料
 * @author 年高
 *
 */
@Entity
@Table(name = "user_profile")
public class UserProfile {
	
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
	
	
	public String getBlog() {
		return blog;
	}
	
	
	public String getBook() {
		return book;
	}
	
	
	public String getConcert() {
		return concert;
	}
	
	public String getCrush() {
		return crush;
	}
	
	
	public String getDonttell() {
		return donttell;
	}
	
	
	
	public String getFilm() {
		return film;
	}



	public String getFind_me_in() {
		return find_me_in;
	}



	public String getFirst_name() {
		return first_name;
	}



	public String getHometown() {
		return hometown;
	}



	public Long getId() {
		return id;
	}



	public String getLast_name() {
		return last_name;
	}



	public String getLastmeal() {
		return lastmeal;
	}



	public String getLove_name() {
		return love_name;
	}



	public String getNickname() {
		return nickname;
	}



	public String getNotyelp() {
		return notyelp;
	}



	public String getPrimary_locale() {
		return primary_locale;
	}



	public String getRecentdiscovery() {
		return recentdiscovery;
	}



	public String getReviews() {
		return reviews;
	}



	public String getSecondsite() {
		return secondsite;
	}



	public String getTagline() {
		return tagline;
	}



	public UserInfo getUser() {
		return user;
	}



	public void setBlog(String blog) {
		this.blog = blog;
	}



	public void setBook(String book) {
		this.book = book;
	}



	public void setConcert(String concert) {
		this.concert = concert;
	}



	public void setCrush(String crush) {
		this.crush = crush;
	}



	public void setDonttell(String donttell) {
		this.donttell = donttell;
	}



	public void setFilm(String film) {
		this.film = film;
	}



	public void setFind_me_in(String find_me_in) {
		this.find_me_in = find_me_in;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public void setHometown(String hometown) {
		this.hometown = hometown;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public void setLastmeal(String lastmeal) {
		this.lastmeal = lastmeal;
	}



	public void setLove_name(String love_name) {
		this.love_name = love_name;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public void setNotyelp(String notyelp) {
		this.notyelp = notyelp;
	}



	public void setPrimary_locale(String primary_locale) {
		this.primary_locale = primary_locale;
	}



	public void setRecentdiscovery(String recentdiscovery) {
		this.recentdiscovery = recentdiscovery;
	}



	public void setReviews(String reviews) {
		this.reviews = reviews;
	}



	public void setSecondsite(String secondsite) {
		this.secondsite = secondsite;
	}



	public void setTagline(String tagline) {
		this.tagline = tagline;
	}



	public void setUser(UserInfo user) {
		this.user = user;
	}
	
	
}
