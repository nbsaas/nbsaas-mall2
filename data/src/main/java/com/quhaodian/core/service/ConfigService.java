package com.quhaodian.core.service;

import com.quhaodian.core.entity.Config;
import com.ada.data.core.Pagination;

public interface ConfigService {
	public Pagination getPage(int pageNo, int pageSize);

	public Config findById(Integer id);

	public Config save(Config bean);

	public Config update(Config bean);

	public Config deleteById(Integer id);
	
	public Config[] deleteByIds(Integer[] ids);
}