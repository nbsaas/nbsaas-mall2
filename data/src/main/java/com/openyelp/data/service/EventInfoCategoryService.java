package com.openyelp.data.service;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.openyelp.data.entity.EventInfoCategory;
import com.openyelp.data.page.EventInfoCategoryPage;

import java.util.List;

public interface EventInfoCategoryService {

	public EventInfoCategory findById(Integer id);

	public EventInfoCategory save(EventInfoCategory bean);

	public EventInfoCategory update(EventInfoCategory bean);

	public EventInfoCategory deleteById(Integer id);
	
	public EventInfoCategory[] deleteByIds(Integer[] ids);
	
	public EventInfoCategoryPage getPage(int pageNo, int pageSize);
	
	
	public Page<EventInfoCategory> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<EventInfoCategory> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	public List<EventInfoCategory> findByPid(Integer id);

}