package com.quhaodian.haodian.data.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.haodian.data.entity.Dictionary;

public interface DictionaryDao extends BaseDao<Dictionary, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public Dictionary findById(Integer id);

	public Dictionary save(Dictionary bean);

	public Dictionary updateByUpdater(Updater<Dictionary> updater);

	public Dictionary deleteById(Integer id);
}