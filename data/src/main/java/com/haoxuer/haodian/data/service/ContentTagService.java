package com.haoxuer.haodian.data.service;

import com.haoxuer.haodian.data.entity.ContentTag;
import com.haoxuer.discover.data.core.Pagination;


public interface ContentTagService {
	public Pagination getPage(int pageNo, int pageSize);

	public ContentTag findById(Integer id);

	public ContentTag save(ContentTag bean);

	public ContentTag update(ContentTag bean);

	public ContentTag deleteById(Integer id);
	
	public ContentTag[] deleteByIds(Integer[] ids);
}