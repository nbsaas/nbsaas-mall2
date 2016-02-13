package com.openyelp.data.dao;


import  com.openyelp.data.core.BaseDao;
import  com.openyelp.data.core.Updater;
import com.openyelp.data.core.Pagination;
import  com.openyelp.data.entity.EventInfo;

public interface EventInfoDao extends BaseDao<EventInfo, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfo findById(Long id);

	public EventInfo save(EventInfo bean);

	public EventInfo updateByUpdater(Updater<EventInfo> updater);

	public EventInfo deleteById(Long id);
}