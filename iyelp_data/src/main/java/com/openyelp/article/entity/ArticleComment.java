package com.openyelp.article.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.openyelp.data.entity.UserInfo;

/**
 * 文章评论
 * 
 * @author 年高
 *
 */
@Entity
@Table(name = "article_comment")
public class ArticleComment implements Serializable {

	private Date addDate;

	private Long articleid;

	private String contents;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Date lastDate;
	private String title;
	
	@ManyToOne()
	private Article article;
	
	@ManyToOne()
	private UserInfo user;

	public Date getAddDate() {
		return addDate;
	}

	public Article getArticle() {
		return article;
	}

	public Long getArticleid() {
		return articleid;
	}

	public String getContents() {
		return contents;
	}

	public Long getId() {
		return id;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public String getTitle() {
		return title;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public void setArticleid(Long articleid) {
		this.articleid = articleid;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

}
