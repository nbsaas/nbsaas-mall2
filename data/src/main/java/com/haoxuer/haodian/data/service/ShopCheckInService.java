package com.haoxuer.haodian.data.service;

import com.haoxuer.haodian.data.entity.ShopCheckIn;
import com.haoxuer.discover.data.core.Pagination;

public interface ShopCheckInService {
	public Pagination getPage(int pageNo, int pageSize);

	public ShopCheckIn findById(Long id);

	public ShopCheckIn save(ShopCheckIn bean);

	public ShopCheckIn update(ShopCheckIn bean);

	public ShopCheckIn deleteById(Long id);
	
	public ShopCheckIn[] deleteByIds(Long[] ids);
}