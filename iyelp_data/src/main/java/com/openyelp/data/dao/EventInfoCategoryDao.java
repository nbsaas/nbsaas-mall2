package com.openyelp.data.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.openyelp.data.entity.EventInfoCategory;

public interface EventInfoCategoryDao extends CriteriaDao<EventInfoCategory, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfoCategory findById(Integer id);

	public EventInfoCategory save(EventInfoCategory bean);

	public EventInfoCategory updateByUpdater(Updater<EventInfoCategory> updater);

	public EventInfoCategory deleteById(Integer id);
}