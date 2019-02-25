package com.haoxuer.haodian.data.service;

import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.haodian.data.entity.Feed;

public interface FeedService {
	public Pagination<Feed> getPage(int pageNo, int pageSize);

	public Feed findById(Long id);

	public Feed save(Feed bean);

	public Feed update(Feed bean);

	public Feed deleteById(Long id);
	
	public Feed[] deleteByIds(Long[] ids);
	
	public Pagination<Feed>  pageByArea(int areaid,int pageNo, int pageSize);
	public Pagination<Feed>  pageByFollow(long userid,int pageNo, int pageSize);
	public Pagination<Feed>  pageByUser(long userid,int pageNo, int pageSize);
	public Pagination<Feed>  pageByFriend(long userid,int pageNo, int pageSize);

}