package com.quhaodian.data.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import com.quhaodian.data.entity.TalkReply;

public interface TalkReplyDao extends CriteriaDao<TalkReply, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public TalkReply findById(Integer id);

	public TalkReply save(TalkReply bean);

	public TalkReply updateByUpdater(Updater<TalkReply> updater);

	public TalkReply deleteById(Integer id);
}