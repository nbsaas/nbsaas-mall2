package com.quhaodian.data.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.entity.EventInfoPhoto;

public interface EventInfoPhotoDao extends BaseDao<EventInfoPhoto, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfoPhoto findById(Long id);

	public EventInfoPhoto save(EventInfoPhoto bean);

	public EventInfoPhoto updateByUpdater(Updater<EventInfoPhoto> updater);

	public EventInfoPhoto deleteById(Long id);
}