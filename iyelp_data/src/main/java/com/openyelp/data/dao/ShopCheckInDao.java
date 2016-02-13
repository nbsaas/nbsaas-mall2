package com.openyelp.data.dao;


import  com.openyelp.data.core.BaseDao;
import  com.openyelp.data.core.Updater;
import com.openyelp.data.core.Pagination;
import  com.openyelp.data.entity.ShopCheckIn;

public interface ShopCheckInDao extends BaseDao<ShopCheckIn, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopCheckIn findById(Long id);

	public ShopCheckIn save(ShopCheckIn bean);

	public ShopCheckIn updateByUpdater(Updater<ShopCheckIn> updater);

	public ShopCheckIn deleteById(Long id);
}