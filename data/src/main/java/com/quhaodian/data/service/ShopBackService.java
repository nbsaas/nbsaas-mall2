package com.quhaodian.data.service;

import com.ada.data.core.Pagination;
import com.quhaodian.data.entity.ShopBack;

public interface ShopBackService {
	public Pagination getPage(int pageNo, int pageSize);

	public ShopBack findById(Long id);

	public ShopBack save(ShopBack bean);

	public ShopBack update(ShopBack bean);

	public ShopBack deleteById(Long id);
	
	public ShopBack[] deleteByIds(Long[] ids);
}