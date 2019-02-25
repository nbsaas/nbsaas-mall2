package com.haoxuer.haodian.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.haodian.data.entity.Feed;

public interface FeedDao extends BaseDao<Feed, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Feed findById(Long id);

	public Feed save(Feed bean);
	
	public Feed addFeed(Object bean);


	public Feed updateByUpdater(Updater<Feed> updater);

	public Feed deleteById(Long id);
}