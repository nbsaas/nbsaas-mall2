package com.openyelp.data.dao;


import  com.openyelp.data.core.BaseDao;
import  com.openyelp.data.core.Updater;
import com.openyelp.data.core.Pagination;
import  com.openyelp.data.entity.EventInfoCategory;

public interface EventInfoCategoryDao extends BaseDao<EventInfoCategory, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfoCategory findById(Integer id);

	public EventInfoCategory save(EventInfoCategory bean);

	public EventInfoCategory updateByUpdater(Updater<EventInfoCategory> updater);

	public EventInfoCategory deleteById(Integer id);
}