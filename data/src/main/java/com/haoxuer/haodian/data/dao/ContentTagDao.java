package com.haoxuer.haodian.data.dao;


import com.haoxuer.discover.data.core.BaseDao;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.haodian.data.entity.ContentTag;

public interface ContentTagDao extends BaseDao<ContentTag, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public ContentTag findById(Integer id);

	public ContentTag save(ContentTag bean);

	public ContentTag updateByUpdater(Updater<ContentTag> updater);

	public ContentTag deleteById(Integer id);
}