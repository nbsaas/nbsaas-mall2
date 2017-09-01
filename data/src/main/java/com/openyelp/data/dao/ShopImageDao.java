package com.openyelp.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.openyelp.data.entity.ShopImage;

public interface ShopImageDao extends BaseDao<ShopImage, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopImage findById(Long id);

	public ShopImage save(ShopImage bean);

	public ShopImage updateByUpdater(Updater<ShopImage> updater);

	public ShopImage deleteById(Long id);
}