package com.openyelp.data.dao;


import com.openyelp.data.core.BaseDao;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.entity.ContentTag;

public interface ContentTagDao extends BaseDao<ContentTag, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public ContentTag findById(Integer id);

	public ContentTag save(ContentTag bean);

	public ContentTag updateByUpdater(Updater<ContentTag> updater);

	public ContentTag deleteById(Integer id);
}