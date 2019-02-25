package com.quhaodian.haodian.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;
import com.quhaodian.haodian.data.entity.ShopReviewList;

public interface ShopReviewListDao extends BaseDao<ShopReviewList, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopReviewList findById(Long id);

	public ShopReviewList save(ShopReviewList bean);

	public ShopReviewList updateByUpdater(Updater<ShopReviewList> updater);

	public ShopReviewList deleteById(Long id);
}