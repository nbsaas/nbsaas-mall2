package com.quhaodian.haodian.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;
import com.quhaodian.haodian.data.entity.Shop;

public interface ShopDao extends BaseDao<Shop, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Shop findById(Long id);

	public Shop save(Shop bean);

	public Shop updateByUpdater(Updater<Shop> updater);

	public Shop deleteById(Long id);
}