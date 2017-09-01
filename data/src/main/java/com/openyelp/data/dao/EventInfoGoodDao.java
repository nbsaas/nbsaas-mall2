package com.openyelp.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.openyelp.data.entity.EventInfoGood;

public interface EventInfoGoodDao extends BaseDao<EventInfoGood, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfoGood findById(Long id);

	public EventInfoGood save(EventInfoGood bean);

	public EventInfoGood updateByUpdater(Updater<EventInfoGood> updater);

	public EventInfoGood deleteById(Long id);
}