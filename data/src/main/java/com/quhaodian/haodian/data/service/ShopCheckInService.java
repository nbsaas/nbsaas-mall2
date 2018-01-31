package com.quhaodian.haodian.data.service;

import com.quhaodian.haodian.data.entity.ShopCheckIn;
import com.quhaodian.data.core.Pagination;

public interface ShopCheckInService {
	public Pagination getPage(int pageNo, int pageSize);

	public ShopCheckIn findById(Long id);

	public ShopCheckIn save(ShopCheckIn bean);

	public ShopCheckIn update(ShopCheckIn bean);

	public ShopCheckIn deleteById(Long id);
	
	public ShopCheckIn[] deleteByIds(Long[] ids);
}