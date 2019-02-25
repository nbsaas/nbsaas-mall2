package com.haoxuer.haodian.data.service;

import com.haoxuer.haodian.data.entity.EventInfoComment;
import com.haoxuer.discover.data.core.Pagination;


public interface EventInfoCommentService {
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfoComment findById(Long id);

	public EventInfoComment save(EventInfoComment bean);

	public EventInfoComment update(EventInfoComment bean);

	public EventInfoComment deleteById(Long id);
	
	public EventInfoComment[] deleteByIds(Long[] ids);
	
	public Pagination pageByEventId(long id,int pageNo, int pageSize);

}