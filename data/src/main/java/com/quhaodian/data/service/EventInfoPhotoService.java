package com.quhaodian.data.service;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.entity.EventInfoPhoto;


public interface EventInfoPhotoService {
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfoPhoto findById(Long id);

	public EventInfoPhoto save(EventInfoPhoto bean);

	public EventInfoPhoto update(EventInfoPhoto bean);

	public EventInfoPhoto deleteById(Long id);
	
	public EventInfoPhoto[] deleteByIds(Long[] ids);
	
	public Pagination pageByEvent(Long id,int pageNo, int pageSize);

}