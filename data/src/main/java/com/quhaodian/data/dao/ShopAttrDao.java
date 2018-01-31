package com.quhaodian.data.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.entity.ShopAttr;

public interface ShopAttrDao extends BaseDao<ShopAttr, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopAttr findById(Long id);

	public ShopAttr save(ShopAttr bean);

	public ShopAttr updateByUpdater(Updater<ShopAttr> updater);

	public ShopAttr deleteById(Long id);
}