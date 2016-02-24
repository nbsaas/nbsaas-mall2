/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 */

package com.openyelp.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 评论实体
 * 
 * @author Administrator
 * 
 */
@Entity
@Table(name = "comment")
public class Comment {

	/**
	 * 评论Id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private long id;
	/**
	 * 所属用户Id
	 */
	private Long userid;
	/**
	 * 父亲Id
	 */
	private Long fatherid;
	/**
	 * 所属种类的Id
	 */
	private long kindid;
	/**
	 * 所属种类
	 */
	private int kind;
	/**
	 * 评论名称
	 */
	@Column(length=50)
	private String name;
	/**
	 * 所属用户email
	 */
	@Column(length=50)
	private String email;
	/**
	 * 评论者网址
	 */
	@Column(length=100)
	private String url;
	/**
	 * 评论内容
	 */
	@Column(length=2000)
	private String content;
	/**
	 * 所属Ip
	 */
	@Column(length=100)
	private String ip;
	/**
	 * 所属phone
	 */
	@Column(length=50)
	private String phone;

	/**
	 * 审核状态
	 */
	private int status;
	/**
	 * 时间
	 */
	@Column(length=50,name="createtime")
	private Date createTime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getFatherid() {
		return fatherid;
	}
	public void setFatherid(Long fatherid) {
		this.fatherid = fatherid;
	}
	public long getKindid() {
		return kindid;
	}
	public void setKindid(long kindid) {
		this.kindid = kindid;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	

}
