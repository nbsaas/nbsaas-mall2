package com.quhaodian.haodian.data.service;

import com.haoxuer.discover.data.core.Pagination;
import com.quhaodian.haodian.data.entity.EntityImg;


public interface EntityImgService {
	public Pagination getPage(int pageNo, int pageSize);

	public EntityImg findById(Integer id);

	public EntityImg save(EntityImg bean);

	public EntityImg update(EntityImg bean);

	public EntityImg deleteById(Integer id);
	
	public EntityImg[] deleteByIds(Integer[] ids);
}