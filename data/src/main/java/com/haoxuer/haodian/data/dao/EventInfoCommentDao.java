package com.haoxuer.haodian.data.dao;


import com.haoxuer.haodian.data.entity.EventInfoComment;
import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;

public interface EventInfoCommentDao extends BaseDao<EventInfoComment, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfoComment findById(Long id);

	public EventInfoComment save(EventInfoComment bean);

	public EventInfoComment updateByUpdater(Updater<EventInfoComment> updater);

	public EventInfoComment deleteById(Long id);
}