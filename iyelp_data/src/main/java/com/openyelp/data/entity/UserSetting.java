package com.openyelp.data.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;


@Entity
@Table(name = "user_setting")
public class UserSetting {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ColumnDefault("")
	private String title="";
	
	@ColumnDefault("")
	private String description="";
	
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userid",unique = true)
	private UserInfo user;
	
	private String share_setting;
	
	@ColumnDefault("1")
	private Integer bookmarksPublic;
	
	@ColumnDefault("1")
	private Integer memberSearch;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public String getShare_setting() {
		return share_setting;
	}

	public void setShare_setting(String share_setting) {
		this.share_setting = share_setting;
	}

	public Integer getBookmarksPublic() {
		return bookmarksPublic;
	}

	public void setBookmarksPublic(Integer bookmarksPublic) {
		this.bookmarksPublic = bookmarksPublic;
	}

	public Integer getMemberSearch() {
		return memberSearch;
	}

	public void setMemberSearch(Integer memberSearch) {
		this.memberSearch = memberSearch;
	}
	
	

}
