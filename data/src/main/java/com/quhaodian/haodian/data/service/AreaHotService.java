package com.quhaodian.haodian.data.service;

import com.quhaodian.haodian.data.entity.AreaHot;
import com.quhaodian.data.core.Pagination;


public interface AreaHotService {
	public Pagination getPage(int pageNo, int pageSize);

	public AreaHot findById(Integer id);

	public AreaHot save(AreaHot bean);

	public AreaHot update(AreaHot bean);

	public AreaHot deleteById(Integer id);
	
	public AreaHot[] deleteByIds(Integer[] ids);

	public Pagination page(int curpage, int pagesize);
}