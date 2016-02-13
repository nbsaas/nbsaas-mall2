package com.openyelp.data.service;

import com.openyelp.annotation.RestFul;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.ShopTag;
@RestFul(value="ShopTagService",api=ShopTagService.class)
public interface ShopTagService {
	public Pagination getPage(int pageNo, int pageSize);

	public ShopTag findById(Long id);

	public ShopTag save(ShopTag bean);

	public ShopTag update(ShopTag bean);

	public ShopTag deleteById(Long id);
	
	public ShopTag[] deleteByIds(Long[] ids);
}