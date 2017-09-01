package com.openyelp.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.openyelp.data.entity.Feed;

public interface FeedDao extends BaseDao<Feed, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Feed findById(Long id);

	public Feed save(Feed bean);
	
	public Feed addFeed(Object bean);


	public Feed updateByUpdater(Updater<Feed> updater);

	public Feed deleteById(Long id);
}