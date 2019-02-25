package com.quhaodian.haodian.data.service;

import com.quhaodian.haodian.data.entity.ShopReviewVote;
import com.haoxuer.discover.data.core.Pagination;

public interface ShopReviewVoteService {
	public Pagination getPage(int pageNo, int pageSize);

	public ShopReviewVote findById(Long id);
	
	public ShopReviewVote findByUser(Long uid,Long shopreviewid,int catalog);


	public ShopReviewVote save(ShopReviewVote bean);
	public int vote(ShopReviewVote bean);

	public ShopReviewVote update(ShopReviewVote bean);

	public ShopReviewVote deleteById(Long id);
	
	public ShopReviewVote[] deleteByIds(Long[] ids);
}