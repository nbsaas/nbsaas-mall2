package com.openyelp.data.dao;


import  com.openyelp.data.core.BaseDao;
import  com.openyelp.data.core.Updater;
import com.openyelp.data.core.Pagination;
import  com.openyelp.data.entity.EventInfoPhoto;

public interface EventInfoPhotoDao extends BaseDao<EventInfoPhoto, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfoPhoto findById(Long id);

	public EventInfoPhoto save(EventInfoPhoto bean);

	public EventInfoPhoto updateByUpdater(Updater<EventInfoPhoto> updater);

	public EventInfoPhoto deleteById(Long id);
}