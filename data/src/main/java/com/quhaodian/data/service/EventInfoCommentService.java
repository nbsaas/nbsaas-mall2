package com.quhaodian.data.service;

import com.ada.data.core.Pagination;
import com.quhaodian.data.entity.EventInfoComment;



public interface EventInfoCommentService {
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfoComment findById(Long id);

	public EventInfoComment save(EventInfoComment bean);

	public EventInfoComment update(EventInfoComment bean);

	public EventInfoComment deleteById(Long id);
	
	public EventInfoComment[] deleteByIds(Long[] ids);
	
	public Pagination pageByEventId(long id,int pageNo, int pageSize);

}