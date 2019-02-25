package com.haoxuer.haodian.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.haodian.data.entity.TalkCategoryArea;

public interface TalkCategoryAreaDao extends BaseDao<TalkCategoryArea, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public TalkCategoryArea findById(Integer id);

	public TalkCategoryArea save(TalkCategoryArea bean);

	public TalkCategoryArea updateByUpdater(Updater<TalkCategoryArea> updater);

	public TalkCategoryArea deleteById(Integer id);
}