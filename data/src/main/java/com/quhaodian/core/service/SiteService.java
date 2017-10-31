package com.quhaodian.core.service;

import com.quhaodian.core.entity.Site;
import com.ada.data.core.Pagination;

public interface SiteService {
	public Pagination getPage(int pageNo, int pageSize);

	public Site findById(Integer id);

	public Site save(Site bean);

	public Site update(Site bean);

	public Site deleteById(Integer id);
	
	public Site[] deleteByIds(Integer[] ids);
}