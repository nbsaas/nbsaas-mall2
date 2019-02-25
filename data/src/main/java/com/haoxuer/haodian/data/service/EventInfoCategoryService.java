package com.haoxuer.haodian.data.service;

import com.haoxuer.haodian.data.entity.EventInfoCategory;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;

import java.util.List;

public interface EventInfoCategoryService {

	public EventInfoCategory findById(Integer id);

	public EventInfoCategory save(EventInfoCategory bean);

	public EventInfoCategory update(EventInfoCategory bean);

	public EventInfoCategory deleteById(Integer id);
	
	public EventInfoCategory[] deleteByIds(Integer[] ids);
	
	public Page<EventInfoCategory> getPage(int pageNo, int pageSize);
	
	
	public Page<EventInfoCategory> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<EventInfoCategory> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	public List<EventInfoCategory> findByPid(Integer id);

}