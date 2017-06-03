package com.quhaodian.data.service;

import com.ada.data.core.Pagination;
import com.quhaodian.data.entity.MessageReply;

public interface MessageReplyService {
	public Pagination getPage(int pageNo, int pageSize);

	public MessageReply findById(Long id);

	public MessageReply save(MessageReply bean);

	public MessageReply update(MessageReply bean);

	public MessageReply deleteById(Long id);
	
	public MessageReply[] deleteByIds(Long[] ids);
	
	
	public Pagination pageByMessage(long id,int pageNo, int pageSize);

}