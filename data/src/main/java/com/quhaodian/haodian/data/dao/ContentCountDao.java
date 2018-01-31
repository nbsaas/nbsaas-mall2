package com.quhaodian.haodian.data.dao;


import com.quhaodian.data.core.BaseDao;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.quhaodian.haodian.data.entity.ContentCount;

public interface ContentCountDao extends BaseDao<ContentCount, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public ContentCount findById(Integer id);

	public ContentCount save(ContentCount bean);

	public ContentCount updateByUpdater(Updater<ContentCount> updater);

	public ContentCount deleteById(Integer id);
}