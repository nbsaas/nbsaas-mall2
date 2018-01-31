package com.quhaodian.haodian.data.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.haodian.data.entity.MessageReply;

public interface MessageReplyDao extends BaseDao<MessageReply, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public MessageReply findById(Long id);

	public MessageReply save(MessageReply bean);

	public MessageReply updateByUpdater(Updater<MessageReply> updater);

	public MessageReply deleteById(Long id);
}