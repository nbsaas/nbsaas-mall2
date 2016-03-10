package com.openyelp.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.openyelp.data.entity.ShopAttr;

public interface ShopAttrDao extends BaseDao<ShopAttr, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopAttr findById(Long id);

	public ShopAttr save(ShopAttr bean);

	public ShopAttr updateByUpdater(Updater<ShopAttr> updater);

	public ShopAttr deleteById(Long id);
}