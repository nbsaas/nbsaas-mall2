package com.quhaodian.data.dao;


import com.quhaodian.data.core.BaseDao;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.quhaodian.data.entity.EntityImg;

public interface EntityImgDao extends BaseDao<EntityImg, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public EntityImg findById(Integer id);

	public EntityImg save(EntityImg bean);

	public EntityImg updateByUpdater(Updater<EntityImg> updater);

	public EntityImg deleteById(Integer id);
}