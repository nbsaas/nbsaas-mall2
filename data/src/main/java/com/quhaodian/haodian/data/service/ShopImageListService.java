package com.quhaodian.haodian.data.service;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.haodian.data.entity.ShopImageList;

public interface ShopImageListService {
	public Pagination getPage(int pageNo, int pageSize);

	public ShopImageList findById(Long id);

	public ShopImageList save(ShopImageList bean);

	public ShopImageList update(ShopImageList bean);

	public ShopImageList deleteById(Long id);
	
	public ShopImageList[] deleteByIds(Long[] ids);
}