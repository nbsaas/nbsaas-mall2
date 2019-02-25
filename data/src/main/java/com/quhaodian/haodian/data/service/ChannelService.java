package com.quhaodian.haodian.data.service;

import com.quhaodian.haodian.data.entity.Channel;
import com.haoxuer.discover.data.core.Pagination;


public interface ChannelService {
	public Pagination getPage(int pageNo, int pageSize);

	public Channel findById(Integer id);

	public Channel save(Channel bean);

	public Channel update(Channel bean);

	public Channel deleteById(Integer id);
	
	public Channel[] deleteByIds(Integer[] ids);
}