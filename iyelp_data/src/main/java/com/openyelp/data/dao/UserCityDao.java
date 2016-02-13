package com.openyelp.data.dao;


import  com.openyelp.data.core.BaseDao;
import  com.openyelp.data.core.Updater;
import com.openyelp.data.core.Pagination;
import  com.openyelp.data.entity.UserCity;

public interface UserCityDao extends BaseDao<UserCity, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserCity findById(Long id);

	public UserCity save(UserCity bean);

	public UserCity updateByUpdater(Updater<UserCity> updater);

	public UserCity deleteById(Long id);
}