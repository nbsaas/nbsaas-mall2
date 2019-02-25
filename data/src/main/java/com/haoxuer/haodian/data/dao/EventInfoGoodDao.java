package com.haoxuer.haodian.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.haodian.data.entity.EventInfoGood;

public interface EventInfoGoodDao extends BaseDao<EventInfoGood, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfoGood findById(Long id);

	public EventInfoGood save(EventInfoGood bean);

	public EventInfoGood updateByUpdater(Updater<EventInfoGood> updater);

	public EventInfoGood deleteById(Long id);
}