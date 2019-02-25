package com.haoxuer.haodian.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.haodian.data.entity.Dictionary;

public interface DictionaryDao extends BaseDao<Dictionary, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public Dictionary findById(Integer id);

	public Dictionary save(Dictionary bean);

	public Dictionary updateByUpdater(Updater<Dictionary> updater);

	public Dictionary deleteById(Integer id);
}