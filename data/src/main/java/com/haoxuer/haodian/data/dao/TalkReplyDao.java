package com.haoxuer.haodian.data.dao;


import  com.haoxuer.discover.data.core.CriteriaDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.haodian.data.entity.TalkReply;

public interface TalkReplyDao extends CriteriaDao<TalkReply, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public TalkReply findById(Integer id);

	public TalkReply save(TalkReply bean);

	public TalkReply updateByUpdater(Updater<TalkReply> updater);

	public TalkReply deleteById(Integer id);
}