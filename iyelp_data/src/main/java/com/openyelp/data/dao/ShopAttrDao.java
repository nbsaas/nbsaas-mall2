package com.openyelp.data.dao;


import  com.openyelp.data.core.BaseDao;
import  com.openyelp.data.core.Updater;
import com.openyelp.data.core.Pagination;
import  com.openyelp.data.entity.ShopAttr;

public interface ShopAttrDao extends BaseDao<ShopAttr, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopAttr findById(Long id);

	public ShopAttr save(ShopAttr bean);

	public ShopAttr updateByUpdater(Updater<ShopAttr> updater);

	public ShopAttr deleteById(Long id);
}