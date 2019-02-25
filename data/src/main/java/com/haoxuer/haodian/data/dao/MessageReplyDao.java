package com.haoxuer.haodian.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.haodian.data.entity.MessageReply;

public interface MessageReplyDao extends BaseDao<MessageReply, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public MessageReply findById(Long id);

	public MessageReply save(MessageReply bean);

	public MessageReply updateByUpdater(Updater<MessageReply> updater);

	public MessageReply deleteById(Long id);
}