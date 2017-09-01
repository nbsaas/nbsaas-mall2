package com.quhaodian.data.service;

import com.ada.data.core.Pagination;
import com.quhaodian.data.entity.EntityContent;

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