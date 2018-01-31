package com.quhaodian.data.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.entity.UserProfile;

public interface UserProfileDao extends BaseDao<UserProfile, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserProfile findById(Long id);

	public UserProfile save(UserProfile bean);

	public UserProfile updateByUpdater(Updater<UserProfile> updater);

	public UserProfile deleteById(Long id);
}