package com.quhaodian.haodian.data.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.haodian.data.entity.TalkReply;

public interface TalkReplyDao extends CriteriaDao<TalkReply, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public TalkReply findById(Integer id);

	public TalkReply save(TalkReply bean);

	public TalkReply updateByUpdater(Updater<TalkReply> updater);

	public TalkReply deleteById(Integer id);
}