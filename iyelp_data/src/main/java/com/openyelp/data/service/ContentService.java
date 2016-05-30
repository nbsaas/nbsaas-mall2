package com.openyelp.data.service;

import com.openyelp.annotation.RestFul;
import com.ada.data.core.Pagination;
import com.openyelp.data.entity.Content;



@RestFul(api=ContentService.class,value="ContentService")
public interface ContentService {
	public Pagination getPage(int pageNo, int pageSize);

	public Content findById(Integer id);

	public Content save(Content bean);

	public Content update(Content bean);

	public Content deleteById(Integer id);
	
	public Content[] deleteByIds(Integer[] ids);
}