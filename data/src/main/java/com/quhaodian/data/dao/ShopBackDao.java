package com.quhaodian.data.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.entity.ShopBack;

public interface ShopBackDao extends BaseDao<ShopBack, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopBack findById(Long id);

	public ShopBack save(ShopBack bean);

	public ShopBack updateByUpdater(Updater<ShopBack> updater);

	public ShopBack deleteById(Long id);
}