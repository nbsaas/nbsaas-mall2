package com.quhaodian.haodian.data.dao;


import com.quhaodian.haodian.data.entity.Channel;
import com.quhaodian.data.core.BaseDao;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;

public interface ChannelDao extends BaseDao<Channel, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public Channel findById(Integer id);

	public Channel save(Channel bean);

	public Channel updateByUpdater(Updater<Channel> updater);

	public Channel deleteById(Integer id);
}