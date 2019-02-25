package com.haoxuer.haodian.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.haodian.data.entity.ShopReviewListItem;

public interface ShopReviewListItemDao extends BaseDao<ShopReviewListItem, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopReviewListItem findById(Long id);

	public ShopReviewListItem save(ShopReviewListItem bean);

	public ShopReviewListItem updateByUpdater(Updater<ShopReviewListItem> updater);

	public ShopReviewListItem deleteById(Long id);
}