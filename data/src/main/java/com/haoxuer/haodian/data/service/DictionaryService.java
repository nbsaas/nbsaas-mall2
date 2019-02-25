package com.haoxuer.haodian.data.service;

import com.haoxuer.haodian.data.entity.Dictionary;
import com.haoxuer.discover.data.core.Pagination;


public interface DictionaryService {
	public Pagination getPage(int pageNo, int pageSize);
	public Pagination page(int pageNo, int pageSize);

	public Dictionary findById(Integer id);

	public Dictionary save(Dictionary bean);

	public Dictionary update(Dictionary bean);

	public Dictionary deleteById(Integer id);
	
	public Dictionary[] deleteByIds(Integer[] ids);
}