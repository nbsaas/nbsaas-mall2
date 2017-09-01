package com.quhaodian.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import com.quhaodian.data.entity.Talk;

public interface TalkDao extends BaseDao<Talk, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Talk findById(Long id);

	public Talk save(Talk bean);

	public Talk updateByUpdater(Updater<Talk> updater);

	public Talk deleteById(Long id);
}