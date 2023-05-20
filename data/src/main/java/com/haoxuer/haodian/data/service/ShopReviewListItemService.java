package com.haoxuer.haodian.data.service;

import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.haodian.data.entity.ShopReviewListItem;

public interface ShopReviewListItemService {
	public Pagination getPage(int pageNo, int pageSize);

	public ShopReviewListItem findById(Long id);

	public ShopReviewListItem save(ShopReviewListItem bean);

	public ShopReviewListItem update(ShopReviewListItem bean);

	public ShopReviewListItem deleteById(Long id);
	
	public ShopReviewListItem[] deleteByIds(Long[] ids);
	
	public Pagination pageByList(Long listid,int pageNo, int pageSize);

}