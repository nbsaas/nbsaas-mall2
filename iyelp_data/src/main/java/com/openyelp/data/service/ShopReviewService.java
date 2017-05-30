package com.openyelp.data.service;

import com.ada.data.core.Pagination;
import com.openyelp.data.entity.ShopReview;



public interface ShopReviewService {
	public Pagination getPage(int pageNo, int pageSize);
	public Pagination page(int pageNo, int pageSize);

	public ShopReview findById(Long id);

	public ShopReview save(ShopReview bean);

	public ShopReview update(ShopReview bean);

	public ShopReview deleteById(Long id);
	
	public ShopReview[] deleteByIds(Long[] ids);
	
	public Pagination pageByShop(Long id,int pageNo, int pageSize);
	public Pagination pageByUser(Long uid,int pageNo, int pageSize);
	
	public Pagination page(int areaid,int catalog,int pageNo, int pageSize);


}