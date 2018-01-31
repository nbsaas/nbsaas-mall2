package com.quhaodian.haodian.data.dao;


import com.quhaodian.haodian.data.entity.EventInfo;
import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;

public interface EventInfoDao extends BaseDao<EventInfo, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfo findById(Long id);

	public EventInfo save(EventInfo bean);

	public EventInfo updateByUpdater(Updater<EventInfo> updater);

	public EventInfo deleteById(Long id);
}