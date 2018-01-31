package com.quhaodian.haodian.data.service;

import com.quhaodian.haodian.data.entity.Talk;
import com.quhaodian.data.core.Pagination;


public interface TalkService {
	public Pagination getPage(int pageNo, int pageSize);

	public Talk findById(Long id);

	public Talk save(Talk bean);

	public Talk update(Talk bean);

	public Talk deleteById(Long id);
	
	public Talk[] deleteByIds(Long[] ids);

	public Talk add(Talk talk, int catalog, String city);
	
	
	public Pagination findByCity(int cityid,int category,int pageNo, int pageSize);

	public Pagination findByCity(int cityid,int category,long userid,int pageNo, int pageSize);

	public Pagination page(int curpage, int pagesize);

}