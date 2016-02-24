package com.openyelp.data.dao;


import  com.openyelp.data.core.BaseDao;
import  com.openyelp.data.core.Updater;
import com.openyelp.data.core.Pagination;
import  com.openyelp.data.entity.UserCompliment;

public interface UserComplimentDao extends BaseDao<UserCompliment, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserCompliment findById(Long id);

	public UserCompliment save(UserCompliment bean);

	public UserCompliment updateByUpdater(Updater<UserCompliment> updater);

	public UserCompliment deleteById(Long id);
}