package com.haoxuer.haodian.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.haodian.data.entity.ShopBookMarks;

public interface ShopBookMarksDao extends BaseDao<ShopBookMarks, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopBookMarks findById(Long id);

	public ShopBookMarks save(ShopBookMarks bean);

	public ShopBookMarks updateByUpdater(Updater<ShopBookMarks> updater);

	public ShopBookMarks deleteById(Long id);
}