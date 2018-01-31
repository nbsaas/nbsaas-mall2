package com.quhaodian.data.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.entity.ShopReviewGood;

public interface ShopReviewGoodDao extends BaseDao<ShopReviewGood, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopReviewGood findById(Long id);

	public ShopReviewGood save(ShopReviewGood bean);

	public ShopReviewGood updateByUpdater(Updater<ShopReviewGood> updater);

	public ShopReviewGood deleteById(Long id);
}