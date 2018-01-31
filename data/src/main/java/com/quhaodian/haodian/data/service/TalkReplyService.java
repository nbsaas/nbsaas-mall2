package com.quhaodian.haodian.data.service;

import com.quhaodian.haodian.data.entity.TalkReply;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;


public interface TalkReplyService {
	public Pagination getPage(int pageNo, int pageSize);

	
	public Pagination pageByTalk(Long talkid,int pageNo, int pageSize);

	public TalkReply findById(Integer id);

	public TalkReply save(TalkReply bean);

	public TalkReply update(TalkReply bean);

	public TalkReply deleteById(Integer id);
	
	public TalkReply[] deleteByIds(Integer[] ids);


	public Page<TalkReply> findPage(Pageable pageable);
}