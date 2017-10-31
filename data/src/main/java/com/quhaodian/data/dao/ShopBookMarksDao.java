package com.quhaodian.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import com.quhaodian.data.entity.ShopBookMarks;

public interface ShopBookMarksDao extends BaseDao<ShopBookMarks, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopBookMarks findById(Long id);

	public ShopBookMarks save(ShopBookMarks bean);

	public ShopBookMarks updateByUpdater(Updater<ShopBookMarks> updater);

	public ShopBookMarks deleteById(Long id);
}