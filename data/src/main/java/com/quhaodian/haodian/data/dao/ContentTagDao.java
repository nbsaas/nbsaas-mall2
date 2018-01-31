package com.quhaodian.haodian.data.dao;


import com.quhaodian.data.core.BaseDao;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.quhaodian.haodian.data.entity.ContentTag;

public interface ContentTagDao extends BaseDao<ContentTag, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public ContentTag findById(Integer id);

	public ContentTag save(ContentTag bean);

	public ContentTag updateByUpdater(Updater<ContentTag> updater);

	public ContentTag deleteById(Integer id);
}