package com.quhaodian.data.service;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.entity.ShopReviewListItem;

public interface ShopReviewListItemService {
	public Pagination getPage(int pageNo, int pageSize);

	public ShopReviewListItem findById(Long id);

	public ShopReviewListItem save(ShopReviewListItem bean);

	public ShopReviewListItem update(ShopReviewListItem bean);

	public ShopReviewListItem deleteById(Long id);
	
	public ShopReviewListItem[] deleteByIds(Long[] ids);
	
	public Pagination pageByList(Long listid,int pageNo, int pageSize);

}