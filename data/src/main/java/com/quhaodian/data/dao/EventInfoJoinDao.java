package com.quhaodian.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import com.quhaodian.data.entity.EventInfoJoin;

public interface EventInfoJoinDao extends BaseDao<EventInfoJoin, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfoJoin findById(Long id);

	public EventInfoJoin save(EventInfoJoin bean);

	public EventInfoJoin updateByUpdater(Updater<EventInfoJoin> updater);

	public EventInfoJoin deleteById(Long id);
}