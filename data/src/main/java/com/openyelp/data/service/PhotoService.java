package com.openyelp.data.service;

import com.ada.data.core.Pagination;
import com.openyelp.data.entity.Photo;



public interface PhotoService {
	public Pagination getPage(int pageNo, int pageSize);

	public Photo findById(Long id);

	public Photo save(Photo bean);

	public Photo update(Photo bean);

	public Photo deleteById(Long id);
	
	public Photo[] deleteByIds(Long[] ids);
	
	public Pagination pageByUser(Long id,int pageNo, int pageSize);

}