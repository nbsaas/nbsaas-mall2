package com.openyelp.data.service;

import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.ShopCheckIn;

public interface ShopCheckInService {
	public Pagination getPage(int pageNo, int pageSize);

	public ShopCheckIn findById(Long id);

	public ShopCheckIn save(ShopCheckIn bean);

	public ShopCheckIn update(ShopCheckIn bean);

	public ShopCheckIn deleteById(Long id);
	
	public ShopCheckIn[] deleteByIds(Long[] ids);
}