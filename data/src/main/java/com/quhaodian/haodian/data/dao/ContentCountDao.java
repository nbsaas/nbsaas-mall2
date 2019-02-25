package com.quhaodian.haodian.data.dao;


import com.haoxuer.discover.data.core.BaseDao;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.discover.data.core.Updater;
import com.quhaodian.haodian.data.entity.ContentCount;

public interface ContentCountDao extends BaseDao<ContentCount, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public ContentCount findById(Integer id);

	public ContentCount save(ContentCount bean);

	public ContentCount updateByUpdater(Updater<ContentCount> updater);

	public ContentCount deleteById(Integer id);
}