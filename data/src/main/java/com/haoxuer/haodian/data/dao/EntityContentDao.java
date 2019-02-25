package com.haoxuer.haodian.data.dao;


import com.haoxuer.discover.data.core.BaseDao;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.haodian.data.entity.EntityContent;

public interface EntityContentDao extends BaseDao<EntityContent, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public EntityContent findById(Integer id);

	public EntityContent save(EntityContent bean);

	public EntityContent updateByUpdater(Updater<EntityContent> updater);

	public EntityContent deleteById(Integer id);
}