package com.quhaodian.haodian.data.service;

import com.quhaodian.haodian.data.entity.UserCity;
import com.quhaodian.data.core.Pagination;


public interface UserCityService {
	public Pagination getPage(int pageNo, int pageSize);

	public UserCity findById(Long id);
	public Pagination findByUser(long userid,int pageNo, int pageSize);

	public UserCity save(UserCity bean);

	public UserCity update(UserCity bean);

	public UserCity deleteById(Long id);
	
	public UserCity[] deleteByIds(Long[] ids);
}