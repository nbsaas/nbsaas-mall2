package com.openyelp.data.dao;


import  com.openyelp.data.core.BaseDao;
import  com.openyelp.data.core.Updater;
import com.openyelp.data.core.Pagination;
import  com.openyelp.data.entity.ShopReviewGood;

public interface ShopReviewGoodDao extends BaseDao<ShopReviewGood, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopReviewGood findById(Long id);

	public ShopReviewGood save(ShopReviewGood bean);

	public ShopReviewGood updateByUpdater(Updater<ShopReviewGood> updater);

	public ShopReviewGood deleteById(Long id);
}