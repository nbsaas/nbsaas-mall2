package com.quhaodian.haodian.data.dao;


import com.quhaodian.haodian.data.entity.EventInfoPhoto;
import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;

public interface EventInfoPhotoDao extends BaseDao<EventInfoPhoto, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfoPhoto findById(Long id);

	public EventInfoPhoto save(EventInfoPhoto bean);

	public EventInfoPhoto updateByUpdater(Updater<EventInfoPhoto> updater);

	public EventInfoPhoto deleteById(Long id);
}