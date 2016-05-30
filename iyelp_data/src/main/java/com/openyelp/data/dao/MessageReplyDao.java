package com.openyelp.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.openyelp.data.entity.MessageReply;

public interface MessageReplyDao extends BaseDao<MessageReply, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public MessageReply findById(Long id);

	public MessageReply save(MessageReply bean);

	public MessageReply updateByUpdater(Updater<MessageReply> updater);

	public MessageReply deleteById(Long id);
}