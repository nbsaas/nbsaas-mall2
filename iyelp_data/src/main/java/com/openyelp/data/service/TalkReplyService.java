package com.openyelp.data.service;

import com.openyelp.annotation.RestFul;
import com.ada.data.core.Pagination;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.openyelp.data.entity.TalkReply;


@RestFul(api=TalkReplyService.class,value="TalkReplyService")
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