package com.haoxuer.haodian.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.haodian.data.entity.UserProfile;

public interface UserProfileDao extends BaseDao<UserProfile, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserProfile findById(Long id);

	public UserProfile save(UserProfile bean);

	public UserProfile updateByUpdater(Updater<UserProfile> updater);

	public UserProfile deleteById(Long id);
}