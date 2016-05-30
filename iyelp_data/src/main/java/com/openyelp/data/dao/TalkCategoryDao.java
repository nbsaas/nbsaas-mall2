package com.openyelp.data.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.openyelp.data.entity.TalkCategory;

public interface TalkCategoryDao extends CriteriaDao<TalkCategory, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public TalkCategory findById(Integer id);

	public TalkCategory save(TalkCategory bean);

	public TalkCategory updateByUpdater(Updater<TalkCategory> updater);

	public TalkCategory deleteById(Integer id);
}