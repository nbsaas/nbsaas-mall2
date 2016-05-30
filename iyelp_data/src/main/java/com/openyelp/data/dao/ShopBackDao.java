package com.openyelp.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.openyelp.data.entity.ShopBack;

public interface ShopBackDao extends BaseDao<ShopBack, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopBack findById(Long id);

	public ShopBack save(ShopBack bean);

	public ShopBack updateByUpdater(Updater<ShopBack> updater);

	public ShopBack deleteById(Long id);
}