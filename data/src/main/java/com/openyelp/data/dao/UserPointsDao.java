package com.openyelp.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.openyelp.data.entity.UserPoints;

public interface UserPointsDao extends BaseDao<UserPoints, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserPoints findById(Long id);

	public UserPoints save(UserPoints bean);

	public UserPoints updateByUpdater(Updater<UserPoints> updater);

	public UserPoints deleteById(Long id);
}