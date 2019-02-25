package com.quhaodian.haodian.data.dao;


import com.quhaodian.haodian.data.entity.Channel;
import com.haoxuer.discover.data.core.BaseDao;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.discover.data.core.Updater;

public interface ChannelDao extends BaseDao<Channel, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public Channel findById(Integer id);

	public Channel save(Channel bean);

	public Channel updateByUpdater(Updater<Channel> updater);

	public Channel deleteById(Integer id);
}