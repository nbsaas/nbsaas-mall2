package com.openyelp.data.service;

import com.openyelp.annotation.RestFul;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.Dictionary;




@RestFul(api=DictionaryService.class,value="DictionaryService")
public interface DictionaryService {
	public Pagination getPage(int pageNo, int pageSize);
	public Pagination page(int pageNo, int pageSize);

	public Dictionary findById(Integer id);

	public Dictionary save(Dictionary bean);

	public Dictionary update(Dictionary bean);

	public Dictionary deleteById(Integer id);
	
	public Dictionary[] deleteByIds(Integer[] ids);
}