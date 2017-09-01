package com.openyelp.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.openyelp.data.entity.UserCompliment;

public interface UserComplimentDao extends BaseDao<UserCompliment, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserCompliment findById(Long id);

	public UserCompliment save(UserCompliment bean);

	public UserCompliment updateByUpdater(Updater<UserCompliment> updater);

	public UserCompliment deleteById(Long id);
}