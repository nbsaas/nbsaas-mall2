package com.openyelp.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.openyelp.data.entity.UserProfile;

public interface UserProfileDao extends BaseDao<UserProfile, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserProfile findById(Long id);

	public UserProfile save(UserProfile bean);

	public UserProfile updateByUpdater(Updater<UserProfile> updater);

	public UserProfile deleteById(Long id);
}