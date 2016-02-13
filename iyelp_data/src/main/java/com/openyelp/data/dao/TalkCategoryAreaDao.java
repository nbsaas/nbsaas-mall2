package com.openyelp.data.dao;


import  com.openyelp.data.core.BaseDao;
import  com.openyelp.data.core.Updater;
import com.openyelp.data.core.Pagination;
import  com.openyelp.data.entity.TalkCategoryArea;

public interface TalkCategoryAreaDao extends BaseDao<TalkCategoryArea, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public TalkCategoryArea findById(Integer id);

	public TalkCategoryArea save(TalkCategoryArea bean);

	public TalkCategoryArea updateByUpdater(Updater<TalkCategoryArea> updater);

	public TalkCategoryArea deleteById(Integer id);
}