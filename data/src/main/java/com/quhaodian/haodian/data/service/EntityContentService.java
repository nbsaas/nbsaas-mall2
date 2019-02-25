package com.quhaodian.haodian.data.service;

import com.haoxuer.discover.data.core.Pagination;
import com.quhaodian.haodian.data.entity.EntityContent;
public interface EntityContentService {
	public Pagination getPage(int pageNo, int pageSize);

	public EntityContent findById(Integer id);
	public EntityContent findByRandom(Integer id);

	public EntityContent save(EntityContent bean);

	public EntityContent update(EntityContent bean);

	public EntityContent deleteById(Integer id);
	
	public EntityContent[] deleteByIds(Integer[] ids);
	public int all();
}