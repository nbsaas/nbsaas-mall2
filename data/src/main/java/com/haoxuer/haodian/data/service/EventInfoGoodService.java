package com.haoxuer.haodian.data.service;

import com.haoxuer.haodian.data.entity.EventInfoGood;
import com.haoxuer.discover.data.core.Pagination;

public interface EventInfoGoodService {
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfoGood findById(Long id);

	public EventInfoGood save(EventInfoGood bean);

	public EventInfoGood update(EventInfoGood bean);

	public EventInfoGood deleteById(Long id);
	
	public EventInfoGood[] deleteByIds(Long[] ids);
	public Pagination pageByArea(int areadid,int pageNo, int pageSize);

}