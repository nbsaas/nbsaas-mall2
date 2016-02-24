package com.openyelp.data.dao;


import  com.openyelp.data.core.BaseDao;
import  com.openyelp.data.core.Updater;
import com.openyelp.data.core.Pagination;
import  com.openyelp.data.entity.ShopTag;

public interface ShopTagDao extends BaseDao<ShopTag, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopTag findById(Long id);

	public ShopTag save(ShopTag bean);

	public ShopTag updateByUpdater(Updater<ShopTag> updater);

	public ShopTag deleteById(Long id);
}