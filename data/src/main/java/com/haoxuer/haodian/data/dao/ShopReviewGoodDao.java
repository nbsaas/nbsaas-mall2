package com.haoxuer.haodian.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.haodian.data.entity.ShopReviewGood;

public interface ShopReviewGoodDao extends BaseDao<ShopReviewGood, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopReviewGood findById(Long id);

	public ShopReviewGood save(ShopReviewGood bean);

	public ShopReviewGood updateByUpdater(Updater<ShopReviewGood> updater);

	public ShopReviewGood deleteById(Long id);
}