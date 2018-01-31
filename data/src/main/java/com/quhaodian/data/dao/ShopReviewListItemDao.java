package com.quhaodian.data.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.entity.ShopReviewListItem;

public interface ShopReviewListItemDao extends BaseDao<ShopReviewListItem, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopReviewListItem findById(Long id);

	public ShopReviewListItem save(ShopReviewListItem bean);

	public ShopReviewListItem updateByUpdater(Updater<ShopReviewListItem> updater);

	public ShopReviewListItem deleteById(Long id);
}