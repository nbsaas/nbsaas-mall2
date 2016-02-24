package com.openyelp.data.dao;


import com.openyelp.data.core.BaseDao;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.entity.EntityContent;

public interface EntityContentDao extends BaseDao<EntityContent, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public EntityContent findById(Integer id);

	public EntityContent save(EntityContent bean);

	public EntityContent updateByUpdater(Updater<EntityContent> updater);

	public EntityContent deleteById(Integer id);
}