package com.quhaodian.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import com.quhaodian.data.entity.ShopTag;

public interface ShopTagDao extends BaseDao<ShopTag, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopTag findById(Long id);

	public ShopTag save(ShopTag bean);

	public ShopTag updateByUpdater(Updater<ShopTag> updater);

	public ShopTag deleteById(Long id);
}