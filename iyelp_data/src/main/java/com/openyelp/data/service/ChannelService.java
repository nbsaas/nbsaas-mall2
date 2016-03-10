package com.openyelp.data.service;

import com.openyelp.annotation.RestFul;
import com.ada.data.core.Pagination;
import com.openyelp.data.entity.Channel;



@RestFul(api=ChannelService.class,value="ChannelService")
public interface ChannelService {
	public Pagination getPage(int pageNo, int pageSize);

	public Channel findById(Integer id);

	public Channel save(Channel bean);

	public Channel update(Channel bean);

	public Channel deleteById(Integer id);
	
	public Channel[] deleteByIds(Integer[] ids);
}