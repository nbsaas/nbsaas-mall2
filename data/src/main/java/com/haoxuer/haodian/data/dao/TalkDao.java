package com.haoxuer.haodian.data.dao;


import com.haoxuer.haodian.data.entity.Talk;
import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;

public interface TalkDao extends BaseDao<Talk, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Talk findById(Long id);

	public Talk save(Talk bean);

	public Talk updateByUpdater(Updater<Talk> updater);

	public Talk deleteById(Long id);
}