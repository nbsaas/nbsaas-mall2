package com.quhaodian.haodian.data.dao;


import com.quhaodian.haodian.data.entity.ShopCheckIn;
import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;

public interface ShopCheckInDao extends BaseDao<ShopCheckIn, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopCheckIn findById(Long id);

	public ShopCheckIn save(ShopCheckIn bean);

	public ShopCheckIn updateByUpdater(Updater<ShopCheckIn> updater);

	public ShopCheckIn deleteById(Long id);
}