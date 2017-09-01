package com.quhaodian.data.dao;


import com.ada.data.core.BaseDao;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.quhaodian.data.entity.Content;

public interface ContentDao extends BaseDao<Content, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public Content findById(Integer id);

	public Content save(Content bean);

	public Content updateByUpdater(Updater<Content> updater);

	public Content deleteById(Integer id);
}