package com.quhaodian.haodian.data.dao;


import com.quhaodian.haodian.data.entity.EventInfoCategory;
import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;

public interface EventInfoCategoryDao extends CriteriaDao<EventInfoCategory, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfoCategory findById(Integer id);

	public EventInfoCategory save(EventInfoCategory bean);

	public EventInfoCategory updateByUpdater(Updater<EventInfoCategory> updater);

	public EventInfoCategory deleteById(Integer id);
}