package com.openyelp.core.dao;


import com.openyelp.core.entity.Config;
import com.ada.data.core.BaseDao;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;

public interface ConfigDao extends BaseDao<Config, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public Config findById(Integer id);

	public Config save(Config bean);

	public Config updateByUpdater(Updater<Config> updater);

	public Config deleteById(Integer id);
}