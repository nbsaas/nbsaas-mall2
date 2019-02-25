package com.haoxuer.haodian.data.service;

import com.haoxuer.haodian.data.entity.TalkReply;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;


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