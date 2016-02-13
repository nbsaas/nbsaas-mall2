package com.openyelp.data.service;

import com.openyelp.annotation.RestFul;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.EventInfoPhoto;


@RestFul(api=EventInfoPhotoService.class,value="EventInfoPhotoService")
public interface EventInfoPhotoService {
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfoPhoto findById(Long id);

	public EventInfoPhoto save(EventInfoPhoto bean);

	public EventInfoPhoto update(EventInfoPhoto bean);

	public EventInfoPhoto deleteById(Long id);
	
	public EventInfoPhoto[] deleteByIds(Long[] ids);
	
	public Pagination pageByEvent(Long id,int pageNo, int pageSize);

}