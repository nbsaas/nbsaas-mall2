package com.haoxuer.haodian.data.dao;


import com.haoxuer.haodian.data.entity.ShopReviewVote;
import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;

public interface ShopReviewVoteDao extends BaseDao<ShopReviewVote, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopReviewVote findById(Long id);

	public ShopReviewVote save(ShopReviewVote bean);

	public ShopReviewVote updateByUpdater(Updater<ShopReviewVote> updater);

	public ShopReviewVote deleteById(Long id);
}