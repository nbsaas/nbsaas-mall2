package com.quhaodian.data.dao;


import com.quhaodian.data.core.BaseDao;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.quhaodian.data.entity.EntityContent;

public interface EntityContentDao extends BaseDao<EntityContent, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public EntityContent findById(Integer id);

	public EntityContent save(EntityContent bean);

	public EntityContent updateByUpdater(Updater<EntityContent> updater);

	public EntityContent deleteById(Integer id);
}