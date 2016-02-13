package com.openyelp.data.service;

import com.openyelp.annotation.RestFul;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.ContentTag;



@RestFul(api=ContentTagService.class,value="ContentTagService")
public interface ContentTagService {
	public Pagination getPage(int pageNo, int pageSize);

	public ContentTag findById(Integer id);

	public ContentTag save(ContentTag bean);

	public ContentTag update(ContentTag bean);

	public ContentTag deleteById(Integer id);
	
	public ContentTag[] deleteByIds(Integer[] ids);
}