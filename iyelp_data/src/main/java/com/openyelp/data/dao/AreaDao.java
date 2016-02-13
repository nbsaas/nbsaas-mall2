package com.openyelp.data.dao;


import  com.openyelp.data.core.BaseDao;
import  com.openyelp.data.core.Updater;
import com.openyelp.data.core.Pagination;
import  com.openyelp.data.entity.Area;

public interface AreaDao extends BaseDao<Area, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public Area findById(Integer id);
	public Area findByName(String id);

	public Area save(Area bean);

	public Area updateByUpdater(Updater<Area> updater);

	public Area deleteById(Integer id);
}