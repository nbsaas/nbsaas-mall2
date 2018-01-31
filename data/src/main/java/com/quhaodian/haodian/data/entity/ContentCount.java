package com.quhaodian.haodian.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "content_count")
public class ContentCount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToOne(mappedBy = "contentCount")
	private Content content;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}
	
	private java.lang.Integer views;
	private java.lang.Integer viewsMonth;
	private java.lang.Integer viewsWeek;
	private java.lang.Integer viewsDay;
	private java.lang.Integer comments;
	private java.lang.Integer commentsMonth;
	private java.lang.Short commentsWeek;
	private java.lang.Short commentsDay;
	private java.lang.Integer downloads;
	private java.lang.Integer downloadsMonth;
	private java.lang.Short downloadsWeek;
	private java.lang.Short downloadsDay;
	private java.lang.Integer ups;
	private java.lang.Integer upsMonth;
	private java.lang.Short upsWeek;
	private java.lang.Short upsDay;
	private java.lang.Integer downs;
	public void init() {
		short zero = 0;
		if (getDowns() == null) {
			setDowns(0);
		}
		if (getViews() == null) {
			setViews(0);
		}
		if (getViewsMonth() == null) {
			setViewsMonth(0);
		}
		if (getViewsWeek() == null) {
			setViewsWeek(0);
		}
		if (getViewsDay() == null) {
			setViewsDay(0);
		}
		if (getComments() == null) {
			setComments(0);
		}
		if (getCommentsMonth() == null) {
			setCommentsMonth(0);
		}
		if (getCommentsWeek() == null) {
			setCommentsWeek(zero);
		}
		if (getCommentsDay() == null) {
			setCommentsDay(zero);
		}
		if (getDownloads() == null) {
			setDownloads(0);
		}
		if (getDownloadsMonth() == null) {
			setDownloadsMonth(0);
		}
		if (getDownloadsWeek() == null) {
			setDownloadsWeek(zero);
		}
		if (getDownloadsDay() == null) {
			setDownloadsDay(zero);
		}
		if (getUps() == null) {
			setUps(0);
		}
		if (getUpsMonth() == null) {
			setUpsMonth(0);
		}
		if (getUpsWeek() == null) {
			setUpsWeek(zero);
		}
		if (getUpsDay() == null) {
			setUpsDay(zero);
		}
	}
	public java.lang.Integer getViews() {
		return views;
	}

	public void setViews(java.lang.Integer views) {
		this.views = views;
	}

	public java.lang.Integer getViewsMonth() {
		return viewsMonth;
	}

	public void setViewsMonth(java.lang.Integer viewsMonth) {
		this.viewsMonth = viewsMonth;
	}

	public java.lang.Integer getViewsWeek() {
		return viewsWeek;
	}

	public void setViewsWeek(java.lang.Integer viewsWeek) {
		this.viewsWeek = viewsWeek;
	}

	public java.lang.Integer getViewsDay() {
		return viewsDay;
	}

	public void setViewsDay(java.lang.Integer viewsDay) {
		this.viewsDay = viewsDay;
	}

	public java.lang.Integer getComments() {
		return comments;
	}

	public void setComments(java.lang.Integer comments) {
		this.comments = comments;
	}

	public java.lang.Integer getCommentsMonth() {
		return commentsMonth;
	}

	public void setCommentsMonth(java.lang.Integer commentsMonth) {
		this.commentsMonth = commentsMonth;
	}

	public java.lang.Short getCommentsWeek() {
		return commentsWeek;
	}

	public void setCommentsWeek(java.lang.Short commentsWeek) {
		this.commentsWeek = commentsWeek;
	}

	public java.lang.Short getCommentsDay() {
		return commentsDay;
	}

	public void setCommentsDay(java.lang.Short commentsDay) {
		this.commentsDay = commentsDay;
	}

	public java.lang.Integer getDownloads() {
		return downloads;
	}

	public void setDownloads(java.lang.Integer downloads) {
		this.downloads = downloads;
	}

	public java.lang.Integer getDownloadsMonth() {
		return downloadsMonth;
	}

	public void setDownloadsMonth(java.lang.Integer downloadsMonth) {
		this.downloadsMonth = downloadsMonth;
	}

	public java.lang.Short getDownloadsWeek() {
		return downloadsWeek;
	}

	public void setDownloadsWeek(java.lang.Short downloadsWeek) {
		this.downloadsWeek = downloadsWeek;
	}

	public java.lang.Short getDownloadsDay() {
		return downloadsDay;
	}

	public void setDownloadsDay(java.lang.Short downloadsDay) {
		this.downloadsDay = downloadsDay;
	}

	public java.lang.Integer getUps() {
		return ups;
	}

	public void setUps(java.lang.Integer ups) {
		this.ups = ups;
	}

	public java.lang.Integer getUpsMonth() {
		return upsMonth;
	}

	public void setUpsMonth(java.lang.Integer upsMonth) {
		this.upsMonth = upsMonth;
	}

	public java.lang.Short getUpsWeek() {
		return upsWeek;
	}

	public void setUpsWeek(java.lang.Short upsWeek) {
		this.upsWeek = upsWeek;
	}

	public java.lang.Short getUpsDay() {
		return upsDay;
	}

	public void setUpsDay(java.lang.Short upsDay) {
		this.upsDay = upsDay;
	}

	public java.lang.Integer getDowns() {
		return downs;
	}

	public void setDowns(java.lang.Integer downs) {
		this.downs = downs;
	}
}
