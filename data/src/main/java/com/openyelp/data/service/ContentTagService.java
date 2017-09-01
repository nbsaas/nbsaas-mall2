package com.openyelp.data.service;

import com.ada.data.core.Pagination;
import com.openyelp.data.entity.ContentTag;



public interface ContentTagService {
	public Pagination getPage(int pageNo, int pageSize);

	public ContentTag findById(Integer id);

	public ContentTag save(ContentTag bean);

	public ContentTag update(ContentTag bean);

	public ContentTag deleteById(Integer id);
	
	public ContentTag[] deleteByIds(Integer[] ids);
}