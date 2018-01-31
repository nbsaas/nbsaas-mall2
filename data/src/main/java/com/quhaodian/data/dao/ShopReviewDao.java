package com.quhaodian.data.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.entity.ShopReview;

public interface ShopReviewDao extends BaseDao<ShopReview, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopReview findById(Long id);

	public ShopReview save(ShopReview bean);

	public ShopReview updateByUpdater(Updater<ShopReview> updater);

	public ShopReview deleteById(Long id);
}