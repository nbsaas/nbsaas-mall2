package com.quhaodian.data.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.entity.ShopTag;

public interface ShopTagDao extends BaseDao<ShopTag, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopTag findById(Long id);

	public ShopTag save(ShopTag bean);

	public ShopTag updateByUpdater(Updater<ShopTag> updater);

	public ShopTag deleteById(Long id);
}