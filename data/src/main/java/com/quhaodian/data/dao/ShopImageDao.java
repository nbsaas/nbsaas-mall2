package com.quhaodian.data.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.entity.ShopImage;

public interface ShopImageDao extends BaseDao<ShopImage, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopImage findById(Long id);

	public ShopImage save(ShopImage bean);

	public ShopImage updateByUpdater(Updater<ShopImage> updater);

	public ShopImage deleteById(Long id);
}