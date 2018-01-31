package com.quhaodian.data.service;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.entity.Channel;


public interface ChannelService {
	public Pagination getPage(int pageNo, int pageSize);

	public Channel findById(Integer id);

	public Channel save(Channel bean);

	public Channel update(Channel bean);

	public Channel deleteById(Integer id);
	
	public Channel[] deleteByIds(Integer[] ids);
}