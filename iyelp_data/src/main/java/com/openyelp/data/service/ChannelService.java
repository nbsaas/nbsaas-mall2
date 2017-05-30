package com.openyelp.data.service;

import com.ada.data.core.Pagination;
import com.openyelp.data.entity.Channel;



public interface ChannelService {
	public Pagination getPage(int pageNo, int pageSize);

	public Channel findById(Integer id);

	public Channel save(Channel bean);

	public Channel update(Channel bean);

	public Channel deleteById(Integer id);
	
	public Channel[] deleteByIds(Integer[] ids);
}