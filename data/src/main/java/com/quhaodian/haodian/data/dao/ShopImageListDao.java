package com.quhaodian.haodian.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;
import com.quhaodian.haodian.data.entity.ShopImageList;

public interface ShopImageListDao extends BaseDao<ShopImageList, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopImageList findById(Long id);

	public ShopImageList save(ShopImageList bean);

	public ShopImageList updateByUpdater(Updater<ShopImageList> updater);

	public ShopImageList deleteById(Long id);
}