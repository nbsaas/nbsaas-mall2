package com.openyelp.data.dao;


import  com.openyelp.data.core.BaseDao;
import  com.openyelp.data.core.Updater;
import com.openyelp.data.core.Pagination;
import  com.openyelp.data.entity.ShopReviewVote;

public interface ShopReviewVoteDao extends BaseDao<ShopReviewVote, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopReviewVote findById(Long id);

	public ShopReviewVote save(ShopReviewVote bean);

	public ShopReviewVote updateByUpdater(Updater<ShopReviewVote> updater);

	public ShopReviewVote deleteById(Long id);
}