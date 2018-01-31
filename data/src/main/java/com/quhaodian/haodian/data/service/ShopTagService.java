package com.quhaodian.haodian.data.service;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.haodian.data.entity.ShopTag;
public interface ShopTagService {
	public Pagination getPage(int pageNo, int pageSize);

	public ShopTag findById(Long id);

	public ShopTag save(ShopTag bean);

	public ShopTag update(ShopTag bean);

	public ShopTag deleteById(Long id);
	
	public ShopTag[] deleteByIds(Long[] ids);
}