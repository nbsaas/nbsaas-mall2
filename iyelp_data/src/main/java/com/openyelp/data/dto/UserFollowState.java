package com.openyelp.data.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.openyelp.data.entity.UserInfo;
import com.openyelp.data.entity.UserProfile;
import com.openyelp.data.entity.UserRole;

public class UserFollowState implements Serializable {

	private UserInfo user;

	public int hashCode() {
		return user.hashCode();
	}

	public Integer getFriends() {
		return user.getFriends();
	}

	public void setFriends(Integer friends) {
		user.setFriends(friends);
	}

	public Integer getComments() {
		return user.getComments();
	}

	public void setComments(Integer comments) {
		user.setComments(comments);
	}

	public Integer getGoods() {
		return user.getGoods();
	}

	public void setGoods(Integer goods) {
		user.setGoods(goods);
	}

	public String getHeadimg() {
		return user.getHeadimg();
	}

	public void setHeadimg(String headimg) {
		user.setHeadimg(headimg);
	}

	public Date getAddDate() {
		return user.getAddDate();
	}

	public boolean equals(Object obj) {
		return user.equals(obj);
	}

	public String getCredentialsSalt() {
		return user.getCredentialsSalt();
	}

	public String getEmail() {
		return user.getEmail();
	}

	public Long getId() {
		return user.getId();
	}

	public Date getLastDate() {
		return user.getLastDate();
	}

	public Integer getLogintimes() {
		return user.getLogintimes();
	}

	public String getMacaddress() {
		return user.getMacaddress();
	}

	public String getName() {
		return user.getName();
	}

	public String getPassword() {
		return user.getPassword();
	}

	public String getPhonenum() {
		return user.getPhonenum();
	}

	public String getPlainPassword() {
		return user.getPlainPassword();
	}

	public UserProfile getProfile() {
		return user.getProfile();
	}

	public Set<UserRole> getRoles() {
		return user.getRoles();
	}

	public String getSalt() {
		return user.getSalt();
	}

	public String getUsername() {
		return user.getUsername();
	}

	public void setAddDate(Date addDate) {
		user.setAddDate(addDate);
	}

	public void setEmail(String email) {
		user.setEmail(email);
	}

	public void setId(Long id) {
		user.setId(id);
	}

	public void setLastDate(Date lastDate) {
		user.setLastDate(lastDate);
	}

	public void setLogintimes(Integer logintimes) {
		user.setLogintimes(logintimes);
	}

	public void setMacaddress(String macaddress) {
		user.setMacaddress(macaddress);
	}

	public void setName(String name) {
		user.setName(name);
	}

	public void setPassword(String password) {
		user.setPassword(password);
	}

	public void setPhonenum(String phonenum) {
		user.setPhonenum(phonenum);
	}

	public void setPlainPassword(String plainPassword) {
		user.setPlainPassword(plainPassword);
	}

	public void setProfile(UserProfile profile) {
		user.setProfile(profile);
	}

	public void setRoles(Set<UserRole> roles) {
		user.setRoles(roles);
	}

	public void setSalt(String salt) {
		user.setSalt(salt);
	}

	public void setUsername(String username) {
		user.setUsername(username);
	}

	public String toString() {
		return user.toString();
	}

	public UserFollowState(UserInfo user) {
		super();
		
		this.user = user;
	}

	private int state;

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}
