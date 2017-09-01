package com.openyelp.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.openyelp.data.entity.Dictionary;

public interface DictionaryDao extends BaseDao<Dictionary, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public Dictionary findById(Integer id);

	public Dictionary save(Dictionary bean);

	public Dictionary updateByUpdater(Updater<Dictionary> updater);

	public Dictionary deleteById(Integer id);
}