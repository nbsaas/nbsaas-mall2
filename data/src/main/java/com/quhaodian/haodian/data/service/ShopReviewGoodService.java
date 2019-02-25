package com.quhaodian.haodian.data.service;

import com.haoxuer.discover.data.core.Pagination;
import com.quhaodian.haodian.data.entity.ShopReviewGood;

public interface ShopReviewGoodService {
	public Pagination getPage(int pageNo, int pageSize);

	public ShopReviewGood findById(Long id);

	public ShopReviewGood save(ShopReviewGood bean);

	public ShopReviewGood update(ShopReviewGood bean);

	public ShopReviewGood deleteById(Long id);
	
	public ShopReviewGood[] deleteByIds(Long[] ids);
	
	
	public Pagination pageByArea(int areaid,int pageNo, int pageSize);

	

}