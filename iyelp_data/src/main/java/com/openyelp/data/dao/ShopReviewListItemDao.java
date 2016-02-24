package com.openyelp.data.dao;


import  com.openyelp.data.core.BaseDao;
import  com.openyelp.data.core.Updater;
import com.openyelp.data.core.Pagination;
import  com.openyelp.data.entity.ShopReviewListItem;

public interface ShopReviewListItemDao extends BaseDao<ShopReviewListItem, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopReviewListItem findById(Long id);

	public ShopReviewListItem save(ShopReviewListItem bean);

	public ShopReviewListItem updateByUpdater(Updater<ShopReviewListItem> updater);

	public ShopReviewListItem deleteById(Long id);
}