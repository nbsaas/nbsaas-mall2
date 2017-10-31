package com.quhaodian.data.service;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.quhaodian.data.entity.TalkCategory;

import java.util.List;

public interface TalkCategoryService {

	public TalkCategory findById(Integer id);

	public TalkCategory save(TalkCategory bean);

	public TalkCategory update(TalkCategory bean);

	public TalkCategory deleteById(Integer id);
	
	public TalkCategory[] deleteByIds(Integer[] ids);
	
	public  Page<TalkCategory> getPage(int pageNo, int pageSize);
	
	
	public Page<TalkCategory> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<TalkCategory> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	public List<TalkCategory> findByPid(int id);
	public List<TalkCategory> findByCity(Integer id);

}