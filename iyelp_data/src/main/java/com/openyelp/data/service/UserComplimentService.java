package com.openyelp.data.service;

import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.UserCompliment;

public interface UserComplimentService {
	public Pagination getPage(int pageNo, int pageSize);

	public UserCompliment findById(Long id);

	public UserCompliment save(UserCompliment bean);

	public UserCompliment update(UserCompliment bean);

	public UserCompliment deleteById(Long id);
	
	public UserCompliment[] deleteByIds(Long[] ids);
	
	public Pagination pageByUser(long id,int pageNo, int pageSize);
	public Pagination pageByUser(long id,int state,int pageNo, int pageSize);

}