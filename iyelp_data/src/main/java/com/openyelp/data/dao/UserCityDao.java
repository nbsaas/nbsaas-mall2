package com.openyelp.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.openyelp.data.entity.UserCity;

public interface UserCityDao extends BaseDao<UserCity, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserCity findById(Long id);

	public UserCity save(UserCity bean);

	public UserCity updateByUpdater(Updater<UserCity> updater);

	public UserCity deleteById(Long id);
}