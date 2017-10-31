package com.quhaodian.data.dao;


import com.ada.data.core.BaseDao;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.quhaodian.data.entity.ContentTag;

public interface ContentTagDao extends BaseDao<ContentTag, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public ContentTag findById(Integer id);

	public ContentTag save(ContentTag bean);

	public ContentTag updateByUpdater(Updater<ContentTag> updater);

	public ContentTag deleteById(Integer id);
}