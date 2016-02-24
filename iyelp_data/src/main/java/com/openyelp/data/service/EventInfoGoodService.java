package com.openyelp.data.service;

import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.EventInfoGood;

public interface EventInfoGoodService {
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfoGood findById(Long id);

	public EventInfoGood save(EventInfoGood bean);

	public EventInfoGood update(EventInfoGood bean);

	public EventInfoGood deleteById(Long id);
	
	public EventInfoGood[] deleteByIds(Long[] ids);
	public Pagination pageByArea(int areadid,int pageNo, int pageSize);

}