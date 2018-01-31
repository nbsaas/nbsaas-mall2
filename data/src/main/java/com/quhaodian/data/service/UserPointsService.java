package com.quhaodian.data.service;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.entity.UserPoints;


public interface UserPointsService {
	public Pagination getPage(int pageNo, int pageSize);

	public UserPoints findById(Long id);

	public UserPoints save(UserPoints bean);

	public UserPoints update(UserPoints bean);

	public UserPoints deleteById(Long id);
	
	public UserPoints[] deleteByIds(Long[] ids);
}