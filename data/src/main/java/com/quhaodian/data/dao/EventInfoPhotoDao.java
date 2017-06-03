package com.quhaodian.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import com.quhaodian.data.entity.EventInfoPhoto;

public interface EventInfoPhotoDao extends BaseDao<EventInfoPhoto, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfoPhoto findById(Long id);

	public EventInfoPhoto save(EventInfoPhoto bean);

	public EventInfoPhoto updateByUpdater(Updater<EventInfoPhoto> updater);

	public EventInfoPhoto deleteById(Long id);
}