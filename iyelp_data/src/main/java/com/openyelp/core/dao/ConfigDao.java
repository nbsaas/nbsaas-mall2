package com.openyelp.core.dao;


import com.openyelp.core.entity.Config;
import com.openyelp.data.core.BaseDao;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;

public interface ConfigDao extends BaseDao<Config, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public Config findById(Integer id);

	public Config save(Config bean);

	public Config updateByUpdater(Updater<Config> updater);

	public Config deleteById(Integer id);
}