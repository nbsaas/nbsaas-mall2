package com.openyelp.data.dao;


import  com.openyelp.data.core.BaseDao;
import  com.openyelp.data.core.Updater;
import com.openyelp.data.core.Pagination;
import  com.openyelp.data.entity.ShopReviewList;

public interface ShopReviewListDao extends BaseDao<ShopReviewList, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopReviewList findById(Long id);

	public ShopReviewList save(ShopReviewList bean);

	public ShopReviewList updateByUpdater(Updater<ShopReviewList> updater);

	public ShopReviewList deleteById(Long id);
}