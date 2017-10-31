package com.quhaodian.data.service;

import com.ada.data.core.Pagination;
import com.quhaodian.data.entity.UserCity;



public interface UserCityService {
	public Pagination getPage(int pageNo, int pageSize);

	public UserCity findById(Long id);
	public Pagination findByUser(long userid,int pageNo, int pageSize);

	public UserCity save(UserCity bean);

	public UserCity update(UserCity bean);

	public UserCity deleteById(Long id);
	
	public UserCity[] deleteByIds(Long[] ids);
}