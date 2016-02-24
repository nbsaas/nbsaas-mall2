package com.openyelp.data.dao;


import  com.openyelp.data.core.BaseDao;
import  com.openyelp.data.core.Updater;
import com.openyelp.data.core.Pagination;
import  com.openyelp.data.entity.EventInfoComment;

public interface EventInfoCommentDao extends BaseDao<EventInfoComment, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfoComment findById(Long id);

	public EventInfoComment save(EventInfoComment bean);

	public EventInfoComment updateByUpdater(Updater<EventInfoComment> updater);

	public EventInfoComment deleteById(Long id);
}