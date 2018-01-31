package com.quhaodian.data.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.entity.ShopReviewList;

public interface ShopReviewListDao extends BaseDao<ShopReviewList, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopReviewList findById(Long id);

	public ShopReviewList save(ShopReviewList bean);

	public ShopReviewList updateByUpdater(Updater<ShopReviewList> updater);

	public ShopReviewList deleteById(Long id);
}