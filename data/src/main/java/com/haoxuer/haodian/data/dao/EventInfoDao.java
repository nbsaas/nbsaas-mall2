package com.haoxuer.haodian.data.dao;


import com.haoxuer.haodian.data.entity.EventInfo;
import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;

public interface EventInfoDao extends BaseDao<EventInfo, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfo findById(Long id);

	public EventInfo save(EventInfo bean);

	public EventInfo updateByUpdater(Updater<EventInfo> updater);

	public EventInfo deleteById(Long id);
}