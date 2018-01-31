package com.quhaodian.haodian.data.service;

import com.quhaodian.haodian.data.entity.EventInfoCategory;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;

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