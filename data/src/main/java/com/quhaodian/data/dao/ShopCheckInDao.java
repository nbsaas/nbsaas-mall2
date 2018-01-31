package com.quhaodian.data.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.entity.ShopCheckIn;

public interface ShopCheckInDao extends BaseDao<ShopCheckIn, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopCheckIn findById(Long id);

	public ShopCheckIn save(ShopCheckIn bean);

	public ShopCheckIn updateByUpdater(Updater<ShopCheckIn> updater);

	public ShopCheckIn deleteById(Long id);
}