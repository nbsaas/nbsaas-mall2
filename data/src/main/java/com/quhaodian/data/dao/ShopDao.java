package com.quhaodian.data.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.entity.Shop;

public interface ShopDao extends BaseDao<Shop, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Shop findById(Long id);

	public Shop save(Shop bean);

	public Shop updateByUpdater(Updater<Shop> updater);

	public Shop deleteById(Long id);
}