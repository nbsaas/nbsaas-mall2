package com.quhaodian.haodian.data.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.quhaodian.user.data.entity.UserInfo;


/**
 * 附件
 * @author 年高
 *
 */
@Entity
@Table(name="attachmentfile")
public class AttachmentFile {

	
	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	private String fileurl;
	private String filetype;
	private int catalog;
	private String name;
	private Timestamp adddate;
	@ManyToOne
	@JoinColumn(name="userid")
	private UserInfo user;
	
	
	
	public Timestamp getAdddate() {
		return adddate;
	}
	public int getCatalog() {
		return catalog;
	}
	public String getFiletype() {
		return filetype;
	}
	public String getFileurl() {
		return fileurl;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public UserInfo getUser() {
		return user;
	}
	public void setAdddate(Timestamp adddate) {
		this.adddate = adddate;
	}
	public void setCatalog(int catalog) {
		this.catalog = catalog;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
}
