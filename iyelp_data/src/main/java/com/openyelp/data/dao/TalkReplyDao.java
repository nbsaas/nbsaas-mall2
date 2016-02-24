package com.openyelp.data.dao;


import  com.openyelp.data.core.BaseDao;
import  com.openyelp.data.core.Updater;
import com.openyelp.data.core.Pagination;
import  com.openyelp.data.entity.TalkReply;

public interface TalkReplyDao extends BaseDao<TalkReply, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public TalkReply findById(Integer id);

	public TalkReply save(TalkReply bean);

	public TalkReply updateByUpdater(Updater<TalkReply> updater);

	public TalkReply deleteById(Integer id);
}