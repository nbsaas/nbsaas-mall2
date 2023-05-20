package com.haoxuer.haodian.data.service;

import com.haoxuer.haodian.data.entity.UserPoints;
import com.haoxuer.discover.data.core.Pagination;


public interface UserPointsService {
	public Pagination getPage(int pageNo, int pageSize);

	public UserPoints findById(Long id);

	public UserPoints save(UserPoints bean);

	public UserPoints update(UserPoints bean);

	public UserPoints deleteById(Long id);
	
	public UserPoints[] deleteByIds(Long[] ids);
}