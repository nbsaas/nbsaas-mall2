package com.quhaodian.data.service;

import com.ada.data.core.Pagination;
import com.quhaodian.data.entity.Content;



public interface ContentService {
	public Pagination getPage(int pageNo, int pageSize);

	public Content findById(Integer id);

	public Content save(Content bean);

	public Content update(Content bean);

	public Content deleteById(Integer id);
	
	public Content[] deleteByIds(Integer[] ids);
}