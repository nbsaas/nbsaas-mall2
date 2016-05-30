package com.openyelp.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.openyelp.data.entity.ShopReview;

public interface ShopReviewDao extends BaseDao<ShopReview, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopReview findById(Long id);

	public ShopReview save(ShopReview bean);

	public ShopReview updateByUpdater(Updater<ShopReview> updater);

	public ShopReview deleteById(Long id);
}