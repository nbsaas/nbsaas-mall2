package com.quhaodian.haodian.data.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.haodian.data.entity.Feed;

public interface FeedDao extends BaseDao<Feed, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Feed findById(Long id);

	public Feed save(Feed bean);
	
	public Feed addFeed(Object bean);


	public Feed updateByUpdater(Updater<Feed> updater);

	public Feed deleteById(Long id);
}