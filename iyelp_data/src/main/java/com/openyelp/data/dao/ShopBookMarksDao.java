package com.openyelp.data.dao;


import  com.openyelp.data.core.BaseDao;
import  com.openyelp.data.core.Updater;
import com.openyelp.data.core.Pagination;
import  com.openyelp.data.entity.ShopBookMarks;

public interface ShopBookMarksDao extends BaseDao<ShopBookMarks, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopBookMarks findById(Long id);

	public ShopBookMarks save(ShopBookMarks bean);

	public ShopBookMarks updateByUpdater(Updater<ShopBookMarks> updater);

	public ShopBookMarks deleteById(Long id);
}