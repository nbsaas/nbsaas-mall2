package com.quhaodian.data.service;

import com.ada.data.core.Pagination;
import com.quhaodian.data.entity.ContentCount;



public interface ContentCountService {
	public Pagination getPage(int pageNo, int pageSize);

	public ContentCount findById(Integer id);

	public ContentCount save(ContentCount bean);

	public ContentCount update(ContentCount bean);

	public ContentCount deleteById(Integer id);
	
	public ContentCount[] deleteByIds(Integer[] ids);
}