package com.openyelp.data.service;

import com.openyelp.annotation.RestFul;
import com.ada.data.core.Pagination;
import com.openyelp.data.entity.EventInfoComment;



@RestFul(api=EventInfoCommentService.class,value="EventInfoCommentService")
public interface EventInfoCommentService {
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfoComment findById(Long id);

	public EventInfoComment save(EventInfoComment bean);

	public EventInfoComment update(EventInfoComment bean);

	public EventInfoComment deleteById(Long id);
	
	public EventInfoComment[] deleteByIds(Long[] ids);
	
	public Pagination pageByEventId(long id,int pageNo, int pageSize);

}