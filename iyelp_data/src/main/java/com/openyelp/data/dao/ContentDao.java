package com.openyelp.data.dao;


import com.openyelp.data.core.BaseDao;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.entity.Content;

public interface ContentDao extends BaseDao<Content, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public Content findById(Integer id);

	public Content save(Content bean);

	public Content updateByUpdater(Updater<Content> updater);

	public Content deleteById(Integer id);
}