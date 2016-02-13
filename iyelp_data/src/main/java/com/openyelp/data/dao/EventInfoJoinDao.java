package com.openyelp.data.dao;


import  com.openyelp.data.core.BaseDao;
import  com.openyelp.data.core.Updater;
import com.openyelp.data.core.Pagination;
import  com.openyelp.data.entity.EventInfoJoin;

public interface EventInfoJoinDao extends BaseDao<EventInfoJoin, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfoJoin findById(Long id);

	public EventInfoJoin save(EventInfoJoin bean);

	public EventInfoJoin updateByUpdater(Updater<EventInfoJoin> updater);

	public EventInfoJoin deleteById(Long id);
}