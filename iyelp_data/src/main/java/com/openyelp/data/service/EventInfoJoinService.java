package com.openyelp.data.service;

import java.util.List;

import com.openyelp.annotation.RestFul;
import com.ada.data.core.Pagination;
import com.openyelp.data.entity.EventInfoJoin;



@RestFul(api=EventInfoJoinService.class,value="EventInfoJoinService")
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