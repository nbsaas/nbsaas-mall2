package com.quhaodian.data.dao;


import com.ada.data.core.BaseDao;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.quhaodian.data.entity.ContentCount;

public interface ContentCountDao extends BaseDao<ContentCount, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public ContentCount findById(Integer id);

	public ContentCount save(ContentCount bean);

	public ContentCount updateByUpdater(Updater<ContentCount> updater);

	public ContentCount deleteById(Integer id);
}