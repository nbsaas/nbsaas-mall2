package com.haoxuer.haodian.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.haodian.data.entity.ShopBack;

public interface ShopBackDao extends BaseDao<ShopBack, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopBack findById(Long id);

	public ShopBack save(ShopBack bean);

	public ShopBack updateByUpdater(Updater<ShopBack> updater);

	public ShopBack deleteById(Long id);
}