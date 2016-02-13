package com.openyelp.data.service;

import java.util.List;

import com.openyelp.annotation.RestFul;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.EventInfoCategory;
import com.openyelp.data.entity.Menu;



@RestFul(api=EventInfoCategoryService.class,value="EventInfoCategoryService")
public interface EventInfoCategoryService {
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfoCategory findById(Integer id);
	public List<EventInfoCategory> findByPid(Integer id);

	public EventInfoCategory save(EventInfoCategory bean);

	public EventInfoCategory update(EventInfoCategory bean);

	public EventInfoCategory deleteById(Integer id);
	
	public EventInfoCategory[] deleteByIds(Integer[] ids);

}