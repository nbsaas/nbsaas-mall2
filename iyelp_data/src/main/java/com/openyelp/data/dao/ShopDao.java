package com.openyelp.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.openyelp.data.entity.Shop;

public interface ShopDao extends BaseDao<Shop, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Shop findById(Long id);

	public Shop save(Shop bean);

	public Shop updateByUpdater(Updater<Shop> updater);

	public Shop deleteById(Long id);
}