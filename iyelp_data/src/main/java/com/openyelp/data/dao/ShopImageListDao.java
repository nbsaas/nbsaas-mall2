package com.openyelp.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.openyelp.data.entity.ShopImageList;

public interface ShopImageListDao extends BaseDao<ShopImageList, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopImageList findById(Long id);

	public ShopImageList save(ShopImageList bean);

	public ShopImageList updateByUpdater(Updater<ShopImageList> updater);

	public ShopImageList deleteById(Long id);
}