package com.quhaodian.haodian.data.service;

import com.haoxuer.discover.data.core.Pagination;
import com.quhaodian.haodian.data.entity.ShopBack;

public interface ShopBackService {
	public Pagination getPage(int pageNo, int pageSize);

	public ShopBack findById(Long id);

	public ShopBack save(ShopBack bean);

	public ShopBack update(ShopBack bean);

	public ShopBack deleteById(Long id);
	
	public ShopBack[] deleteByIds(Long[] ids);
}