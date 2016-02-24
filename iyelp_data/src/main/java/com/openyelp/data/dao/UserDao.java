package com.openyelp.data.dao;


import com.openyelp.data.core.BaseDao;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.entity.UserInfo;

public interface UserDao extends BaseDao<UserInfo, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserInfo findById(Long id);

	public UserInfo save(UserInfo bean);

	public UserInfo updateByUpdater(Updater<UserInfo> updater);

	public UserInfo deleteById(Long id);
}