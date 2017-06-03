package com.quhaodian.core.dao;


import com.quhaodian.core.entity.Site;
import com.ada.data.core.BaseDao;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;

public interface SiteDao extends BaseDao<Site, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public Site findById(Integer id);

	public Site save(Site bean);

	public Site updateByUpdater(Updater<Site> updater);

	public Site deleteById(Integer id);
}