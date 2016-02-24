package com.openyelp.article.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.openyelp.annotation.NoGson;
import com.openyelp.data.entity.UserInfo;

/**
 * 文章
 * 
 * @author 年高
 *
 */
@Entity
@Table(name = "article")
public class Article implements Serializable {

	private Date addDate;

	@NoGson
	@ManyToOne
	private ArticleCatalog catalog;

	
	@ManyToOne()
	private UserInfo user;
	
	
	private String contents;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String img;
	
	private String introduction;
	
	private Date lastDate;

	@NoGson
	@JoinTable(name = "article_link_tag")
	@ManyToMany
	private Set<ArticleTag> tags;

	private String title;

	private String exts;

	private String images;
	
	private Integer ups;

	private Integer comments;
	
	public Date getAddDate() {
		return addDate;
	}
	
	public ArticleCatalog getCatalog() {
		return catalog;
	}

	public Integer getComments() {
		if(comments==null){
			comments=0;
		}
		return comments;
	}
	public String getContents() {
		return contents;
	}
	public String getExts() {
		return exts;
	}
	public Long getId() {
		return id;
	}
	public String getImages() {
		return images;
	}
	public String getImg() {
		return img;
	}
	public String getIntroduction() {
		return introduction;
	}
	public Date getLastDate() {
		return lastDate;
	}
	public Set<ArticleTag> getTags() {
		if(tags==null){
			tags=new HashSet<ArticleTag>();
		}
		return tags;
	}
	public String getTitle() {
		return title;
	}

	public Integer getUps() {
		if(ups==null){
			ups=0;
		}
		return ups;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public void setCatalog(ArticleCatalog catalog) {
		this.catalog = catalog;
	}

	public void setComments(Integer comments) {
		this.comments = comments;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setExts(String exts) {
		this.exts = exts;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public void setTags(Set<ArticleTag> tags) {
		this.tags = tags;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUps(Integer ups) {
		this.ups = ups;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

}
