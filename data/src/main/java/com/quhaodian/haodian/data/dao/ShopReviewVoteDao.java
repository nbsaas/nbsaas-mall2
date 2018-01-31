package com.quhaodian.haodian.data.dao;


import com.quhaodian.haodian.data.entity.ShopReviewVote;
import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;

public interface ShopReviewVoteDao extends BaseDao<ShopReviewVote, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopReviewVote findById(Long id);

	public ShopReviewVote save(ShopReviewVote bean);

	public ShopReviewVote updateByUpdater(Updater<ShopReviewVote> updater);

	public ShopReviewVote deleteById(Long id);
}