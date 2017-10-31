package com.quhaodian.data.service;

import com.ada.data.core.Pagination;
import com.quhaodian.data.entity.ShopReviewList;

public interface ShopReviewListService {
	public Pagination getPage(int pageNo, int pageSize);

	public ShopReviewList findById(Long id);

	public ShopReviewList save(ShopReviewList bean);

	public ShopReviewList update(ShopReviewList bean);

	public ShopReviewList deleteById(Long id);
	
	public ShopReviewList[] deleteByIds(Long[] ids);
	
	
	public Pagination pageByUser(Long uid,int pageNo, int pageSize);
	
	public Pagination pageByArea(int areaid,int pageNo, int pageSize);

	public Pagination pageByArea(String area,int pageNo, int pageSize);
	public Pagination pageByArea(String key,String area,int pageNo, int pageSize);

}