package com.quhaodian.haodian.data.dao;


import com.quhaodian.haodian.data.entity.ShopReview;
import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;

public interface ShopReviewDao extends BaseDao<ShopReview, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopReview findById(Long id);

	public ShopReview save(ShopReview bean);

	public ShopReview updateByUpdater(Updater<ShopReview> updater);

	public ShopReview deleteById(Long id);
}