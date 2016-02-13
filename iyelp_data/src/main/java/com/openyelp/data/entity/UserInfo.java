/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.openyelp.data.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Simple class that represents any User domain entity in any application.
 *
 * <p>
 * Because this class performs its own Realm and Permission checks, and these
 * can happen frequently enough in a production application, it is highly
 * recommended that the internal User {@link #getRoles} collection be cached in
 * a 2nd-level cache when using JPA and/or Hibernate. The hibernate xml
 * configuration for this sample application does in fact do this for your
 * reference (see User.hbm.xml - the 'roles' declaration).
 * </p>
 */
@Entity
@Table(name = "user_info")
public class UserInfo {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@OneToOne(mappedBy = "user")
	private UserProfile profile;
	
	private String username;

	private String name;
	/**
	 * 朋友数量
	 */
	private Integer friends;
	/**
	 * 点评数量
	 */
	private Integer comments;
	
	/**
	 * 精英点评数量
	 */
	private Integer goods;

	public Integer getFriends() {
		return friends;
	}


	public void setFriends(Integer friends) {
		this.friends = friends;
	}


	public Integer getComments() {
		return comments;
	}


	public void setComments(Integer comments) {
		this.comments = comments;
	}


	public Integer getGoods() {
		return goods;
	}


	public void setGoods(Integer goods) {
		this.goods = goods;
	}



	private String headimg;
	public String getHeadimg() {
		return headimg;
	}


	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}



	private String phonenum;
	@Column(nullable=true)
	private String email;

	private String password;

	private String macaddress;

	private Date addDate=new Date();

	private Date lastDate=new Date();

	private Integer logintimes;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_role_links")
	private Set<UserRole> roles = new HashSet<UserRole>();
	private String salt; // 加密密码的盐
	
	@Transient
	private String plainPassword;
	public Date getAddDate() {
		return addDate;
	}

	
	public String getCredentialsSalt() {
		return username + salt;
	}

	public String getEmail() {
		return email;
	}


	public Long getId() {
		return id;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public Integer getLogintimes() {
		return logintimes;
	}

	public String getMacaddress() {
		return macaddress;
	}

	public String getName() {
		return name;
	}

	/**
	 * Returns the password for this user.
	 *
	 * @return this user's password
	 */

	public String getPassword() {
		return password;
	}

	public String getPhonenum() {
		return phonenum;
	}

	// 不持久化到数据库，也不显示在Restful接口的属性.
	
	@JsonIgnore
	public String getPlainPassword() {
		return plainPassword;
	}

	public UserProfile getProfile() {
		return profile;
	}


	public Set<UserRole> getRoles() {
		if(roles==null){
			roles=new HashSet<UserRole>();
		}
		return roles;
	}

	public String getSalt() {
		return salt;
	}

	/**
	 * Returns the username associated with this user account;
	 *
	 * @return the username associated with this user account;
	 */
	public String getUsername() {
		return username;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public void setLogintimes(Integer logintimes) {
		this.logintimes = logintimes;
	}

	public void setMacaddress(String macaddress) {
		this.macaddress = macaddress;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}

	public void setProfile(UserProfile profile) {
		this.profile = profile;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
