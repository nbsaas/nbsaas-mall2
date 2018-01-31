package com.quhaodian.haodian.data.service;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.haodian.data.entity.Content;



public interface ContentService {
	public Pagination getPage(int pageNo, int pageSize);

	public Content findById(Integer id);

	public Content save(Content bean);

	public Content update(Content bean);

	public Content deleteById(Integer id);
	
	public Content[] deleteByIds(Integer[] ids);
}