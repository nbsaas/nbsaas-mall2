package com.quhaodian.haodian.data.service;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.haodian.data.entity.EventInfoJoin;

import java.util.List;



public interface EventInfoJoinService {
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfoJoin findById(Long id);

	public EventInfoJoin save(EventInfoJoin bean);

	public EventInfoJoin update(EventInfoJoin bean);

	public EventInfoJoin deleteById(Long id);
	
	public EventInfoJoin[] deleteByIds(Long[] ids);
	
	
	public Pagination pageByType(int type,int pageNo, int pageSize);
	public Pagination pageByType(Long eventid,int type,int pageNo, int pageSize);

	public List<EventInfoJoin> pageByMe(long id,long eventid);
	public EventInfoJoin findByMe(long id,long eventid);

	public Pagination pageByArea(int  areadid,int pageNo, int pageSize);



}