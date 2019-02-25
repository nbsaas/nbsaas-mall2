package com.quhaodian.haodian.data.dao;


import com.haoxuer.discover.data.core.BaseDao;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.discover.data.core.Updater;
import com.quhaodian.haodian.data.entity.EntityImg;

public interface EntityImgDao extends BaseDao<EntityImg, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public EntityImg findById(Integer id);

	public EntityImg save(EntityImg bean);

	public EntityImg updateByUpdater(Updater<EntityImg> updater);

	public EntityImg deleteById(Integer id);
}