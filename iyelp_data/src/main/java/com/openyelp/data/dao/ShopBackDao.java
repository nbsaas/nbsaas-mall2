package com.openyelp.data.dao;


import  com.openyelp.data.core.BaseDao;
import  com.openyelp.data.core.Updater;
import com.openyelp.data.core.Pagination;
import  com.openyelp.data.entity.ShopBack;

public interface ShopBackDao extends BaseDao<ShopBack, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopBack findById(Long id);

	public ShopBack save(ShopBack bean);

	public ShopBack updateByUpdater(Updater<ShopBack> updater);

	public ShopBack deleteById(Long id);
}