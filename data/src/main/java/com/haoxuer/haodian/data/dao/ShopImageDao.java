package com.haoxuer.haodian.data.dao;


import com.haoxuer.haodian.data.entity.ShopImage;
import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;

public interface ShopImageDao extends BaseDao<ShopImage, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopImage findById(Long id);

	public ShopImage save(ShopImage bean);

	public ShopImage updateByUpdater(Updater<ShopImage> updater);

	public ShopImage deleteById(Long id);
}