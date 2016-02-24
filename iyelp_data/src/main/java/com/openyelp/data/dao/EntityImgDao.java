package com.openyelp.data.dao;


import com.openyelp.data.core.BaseDao;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.entity.EntityImg;

public interface EntityImgDao extends BaseDao<EntityImg, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public EntityImg findById(Integer id);

	public EntityImg save(EntityImg bean);

	public EntityImg updateByUpdater(Updater<EntityImg> updater);

	public EntityImg deleteById(Integer id);
}