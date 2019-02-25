package com.quhaodian.haodian.data.dao;


import com.haoxuer.discover.data.core.BaseDao;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.discover.data.core.Updater;
import com.quhaodian.haodian.data.entity.Content;

public interface ContentDao extends BaseDao<Content, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public Content findById(Integer id);

	public Content save(Content bean);

	public Content updateByUpdater(Updater<Content> updater);

	public Content deleteById(Integer id);
}