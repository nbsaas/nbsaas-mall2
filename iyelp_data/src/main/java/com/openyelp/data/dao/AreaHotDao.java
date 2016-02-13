package com.openyelp.data.dao;


import  com.openyelp.data.core.BaseDao;
import  com.openyelp.data.core.Updater;
import com.openyelp.data.core.Pagination;
import  com.openyelp.data.entity.AreaHot;

public interface AreaHotDao extends BaseDao<AreaHot, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public AreaHot findById(Integer id);

	public AreaHot save(AreaHot bean);

	public AreaHot updateByUpdater(Updater<AreaHot> updater);

	public AreaHot deleteById(Integer id);
}