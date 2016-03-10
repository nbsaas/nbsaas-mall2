package com.openyelp.data.service;

import com.ada.data.core.Pagination;
import com.openyelp.annotation.RestFul;
import com.openyelp.data.entity.AreaHot; 



@RestFul(value="AreaHotService",api=AreaHotService.class)
public interface AreaHotService {
	public Pagination getPage(int pageNo, int pageSize);

	public AreaHot findById(Integer id);

	public AreaHot save(AreaHot bean);

	public AreaHot update(AreaHot bean);

	public AreaHot deleteById(Integer id);
	
	public AreaHot[] deleteByIds(Integer[] ids);

	public Pagination page(int curpage, int pagesize);
}