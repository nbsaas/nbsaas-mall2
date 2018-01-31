package com.quhaodian.haodian.data.dao;


import com.quhaodian.haodian.data.entity.TalkCategory;
import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;

public interface TalkCategoryDao extends CriteriaDao<TalkCategory, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public TalkCategory findById(Integer id);

	public TalkCategory save(TalkCategory bean);

	public TalkCategory updateByUpdater(Updater<TalkCategory> updater);

	public TalkCategory deleteById(Integer id);
}