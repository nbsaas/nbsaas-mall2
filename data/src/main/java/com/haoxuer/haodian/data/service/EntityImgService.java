package com.haoxuer.haodian.data.service;

import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.haodian.data.entity.EntityImg;


public interface EntityImgService {
	public Pagination getPage(int pageNo, int pageSize);

	public EntityImg findById(Integer id);

	public EntityImg save(EntityImg bean);

	public EntityImg update(EntityImg bean);

	public EntityImg deleteById(Integer id);
	
	public EntityImg[] deleteByIds(Integer[] ids);
}