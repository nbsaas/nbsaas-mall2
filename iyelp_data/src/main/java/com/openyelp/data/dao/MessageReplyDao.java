package com.openyelp.data.dao;


import  com.openyelp.data.core.BaseDao;
import  com.openyelp.data.core.Updater;
import com.openyelp.data.core.Pagination;
import  com.openyelp.data.entity.MessageReply;

public interface MessageReplyDao extends BaseDao<MessageReply, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public MessageReply findById(Long id);

	public MessageReply save(MessageReply bean);

	public MessageReply updateByUpdater(Updater<MessageReply> updater);

	public MessageReply deleteById(Long id);
}