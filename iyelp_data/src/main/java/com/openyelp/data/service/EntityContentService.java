package com.openyelp.data.service;

import com.openyelp.annotation.RestFul;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.EntityContent;
@RestFul(api=EntityContentService.class,value="EntityContentService")
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