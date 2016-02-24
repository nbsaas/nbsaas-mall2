package com.openyelp.data.dao;


import  com.openyelp.data.core.BaseDao;
import  com.openyelp.data.core.Updater;
import com.openyelp.data.core.Pagination;
import  com.openyelp.data.entity.Feed;

public interface FeedDao extends BaseDao<Feed, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Feed findById(Long id);

	public Feed save(Feed bean);
	
	public Feed addFeed(Object bean);


	public Feed updateByUpdater(Updater<Feed> updater);

	public Feed deleteById(Long id);
}