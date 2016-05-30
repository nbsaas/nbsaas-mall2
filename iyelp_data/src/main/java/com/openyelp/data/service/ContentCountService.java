package com.openyelp.data.service;

import com.openyelp.annotation.RestFul;
import com.ada.data.core.Pagination;
import com.openyelp.data.entity.ContentCount;



@RestFul(api=ContentCountService.class,value="ContentCountService")
public interface ContentCountService {
	public Pagination getPage(int pageNo, int pageSize);

	public ContentCount findById(Integer id);

	public ContentCount save(ContentCount bean);

	public ContentCount update(ContentCount bean);

	public ContentCount deleteById(Integer id);
	
	public ContentCount[] deleteByIds(Integer[] ids);
}