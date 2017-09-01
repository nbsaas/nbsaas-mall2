package com.quhaodian.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import com.quhaodian.data.entity.TalkCategoryArea;

public interface TalkCategoryAreaDao extends BaseDao<TalkCategoryArea, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public TalkCategoryArea findById(Integer id);

	public TalkCategoryArea save(TalkCategoryArea bean);

	public TalkCategoryArea updateByUpdater(Updater<TalkCategoryArea> updater);

	public TalkCategoryArea deleteById(Integer id);
}