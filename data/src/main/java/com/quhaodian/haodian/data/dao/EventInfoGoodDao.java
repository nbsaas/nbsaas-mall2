package com.quhaodian.haodian.data.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.haodian.data.entity.EventInfoGood;

public interface EventInfoGoodDao extends BaseDao<EventInfoGood, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfoGood findById(Long id);

	public EventInfoGood save(EventInfoGood bean);

	public EventInfoGood updateByUpdater(Updater<EventInfoGood> updater);

	public EventInfoGood deleteById(Long id);
}